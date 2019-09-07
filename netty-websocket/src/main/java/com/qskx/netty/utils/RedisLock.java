package com.qskx.netty.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * 描述:
 * 该方法适合请求合并业务
 *
 * @author cg
 * @create 2019-08-12 上午3:18
 */
@Slf4j
public class RedisLock implements Lock {

    private static volatile int state;
    private static volatile Thread thread;

    RedisTemplate redisTemplate;

    ValueOperations<String, String> valueOperations;
    /**
     * Lock key path.
     */
    String lockKey;

    /**
     * 锁超时时间
     */
    int expireMsecs = 60 * 1000; //锁超时，防止线程在入锁以后，无限的执行等待


    private boolean locked = false;

    public RedisLock(RedisTemplate redisTemplate, String lockKey) {
        this.redisTemplate = redisTemplate;
        this.valueOperations = redisTemplate.opsForValue();
        this.lockKey = lockKey;
    }

    public RedisLock(RedisTemplate redisTemplate, String lockKey, int expireMsecs) {
        this(redisTemplate, lockKey);
        this.expireMsecs = expireMsecs;
    }

    public RedisLock(String lockKey) {
        this(null, lockKey);
    }

    public RedisLock(String lockKey, int expireMsecs) {
        this(null, lockKey, expireMsecs);
    }

    /**
     * @return lock key
     */
    public String getLockKey() {
        return lockKey;
    }

    /**
     * 获取锁不参与轮询逻辑
     *
     * @param expiresTime 过期时间
     * @return true / false
     */
    public boolean acquire(long expiresTime) {
        long expires = System.currentTimeMillis() + expireMsecs + 1;
        String expiresStr = String.valueOf(expires); //锁到期时间
        if (valueOperations.setIfAbsent(lockKey, expiresStr)) {
            redisTemplate.expire(lockKey, expiresTime, TimeUnit.SECONDS);
            locked = true;
            return locked;
        }
        return false;
    }

    /**
     * 获取执行权
     */
    private synchronized boolean acquire(ValueOperations<String, String> valueOperations) throws InterruptedException {

        long expires = System.currentTimeMillis() + expireMsecs + 1;
        String expiresStr = String.valueOf(expires); //锁到期时间
        if (valueOperations.setIfAbsent(lockKey, expiresStr)) {
            locked = true;
            return locked;
        }

        //轮询解锁
        while (!isRelease()) {

            String currentValueStr = valueOperations.get(lockKey); //redis里的时间
            if (currentValueStr != null && Long.parseLong(currentValueStr) < System.currentTimeMillis()) {
                //判断是否为空，不为空的情况下，如果被其他线程设置了值，则第二个条件判断是过不去的
                // lock is expired
                expiresStr = String.valueOf(System.currentTimeMillis() + expireMsecs + 1);
                String oldValueStr = valueOperations.getAndSet(lockKey, expiresStr);
                //获取上一个锁到期时间，并设置现在的锁到期时间，
                //只有一个线程才能获取上一个线上的设置时间，因为jedis.getSet是同步的
                if (oldValueStr != null && oldValueStr.equals(currentValueStr)) {
                    //如过这个时候，多个线程恰好都到了这里，但是只有一个线程的设置值和当前值相同，他才有权利获取锁
                    // lock acquired
                    locked = true;
                    return true;
                }
            }
            Thread.sleep(100);
        }
        locked = false;
        return false;
    }

    /**
     * 判断锁的状态 true 为有锁在执行 并且不是死锁
     */
    public boolean getLockIsAvailable() {
        String currentValueStr = valueOperations.get(lockKey);
        if (currentValueStr != null && Long.parseLong(currentValueStr) > System.currentTimeMillis()) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * 释放锁
     */
    public synchronized void release() {
        release(redisTemplate);
    }

    private synchronized void release(RedisTemplate redisTemplate) {
        if (locked) {
            redisTemplate.delete(lockKey);
            locked = false;
        }
    }

    public boolean isRelease() {
        return valueOperations.get(lockKey) == null ? true : false;
    }

    @Override
    public void lock() {
        try {
            if (!tryLock(1)) {
                Thread.currentThread().interrupt();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {

    }

    @Override
    public boolean tryLock() {
        try {
            return tryLock(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }

    @Override
    public void unlock() {
        tryRelease(1);
    }

    @Override
    public Condition newCondition() {
        return null;
    }

    private synchronized boolean tryLock(int acquires) throws Exception {
        Thread curThread = Thread.currentThread();
        int state = getState();
        if (state == 0) {
            if (compareAndSetState(0, acquires, curThread)) {
                return true;
            }
        } else if (curThread == getThread()) {
            int nextS = getState() + acquires;
            if (nextS < 0) {
                throw new Exception("Maximum lock count exceeded");
            }
            setState(nextS);
            log.info("{} :获取重入锁成功,当前获取锁次数: {}", Thread.currentThread().getName(), getState());
            return true;
        }
        return false;
    }

    public synchronized boolean compareAndSetState(int expect, int update, Thread t) throws InterruptedException {
        if (expect == getState() && acquire(valueOperations)) {
            setState(update);
            RedisLock.thread = t;
            log.info("{} :获取锁成功,当前获取锁次数: {}", Thread.currentThread().getName(), getState());
            return true;
        }
        return false;
    }

    public final boolean tryRelease(int releases) {
        Thread currentThread = Thread.currentThread();
        if (currentThread != getThread()) {
            return false;
        }
        int nextState = getState() - releases;
        boolean free = false;
        if (nextState == 0) {
            free = true;
            setThread(null);
            redisTemplate.delete(lockKey);
        }
        setState(nextState);
        return free;
    }

    public static int getState() {
        return state;
    }

    public static void setState(int state) {
        RedisLock.state = state;
    }

    public static Thread getThread() {
        return thread;
    }

    public static void setThread(Thread thread) {
        RedisLock.thread = thread;
    }
}
