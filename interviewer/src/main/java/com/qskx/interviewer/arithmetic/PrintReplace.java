package com.qskx.interviewer.arithmetic;

/**
 * @ProjectName: springboot-advance
 * @ClassName: PrintReplace
 * @Author: cg
 * @CreateDate: 2020-02-29 14:12
 * @Version: 1.0
 * Copyright: Copyright (c) 2020
 */
public class PrintReplace {
    private static String s = "20200229";

    private static int index = 0;

    private static Object ob = new Object();

    public static void print01() {
        Thread t1 = new Thread(new Runnable(){
            public void run(){
                // volatile vs sychronized 有啥区别
                while (index < s.length()) {
                    synchronized(ob) {
                        ob.notify();
                        System.out.println("thread1:" + s.substring(index, ++index));
                        // 这里notify/wait 会exception；容错处理
                        try {
                            ob.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        // 除了notify/wait，再选一种实现方式？（等价AQS，lock）
                    }
                }
            }
        });
        t1.start();
    }

    public static void print02() {
        Thread t2 = new Thread(new Runnable(){
            public void run(){
                while (index < s.length()) {
                    synchronized(ob) {
                        // 问题3：如果print02()方法先执行，会发生什么？是不是就堵塞在这？print01也没法执行？
                        // 你推演下，因为01 02两个方法的调度顺序，先后顺序是不确定的；（如果02先被OS调度）
                        // 你听的清楚吗？
                        try {
                            ob.wait();// 这时候对象锁释放吗？
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        // 2. ++index是原子的吗？在这里是否有问题？
                        System.out.println("thread2:" + s.substring(index, ++index));
                        ob.notify();
                    }
                }
            }
        });
        t2.start();
    }

    public static void main(String[] args){
        print02();
        print01();
    }
}
