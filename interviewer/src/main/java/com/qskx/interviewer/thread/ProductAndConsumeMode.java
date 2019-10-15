package com.qskx.interviewer.thread;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.TimeUnit;

/**
 * @ProjectName: springboot-advance
 * @ClassName: ProductAndConsumeMode
 * @Author: cg
 * @CreateDate: 2019-09-09 09:54
 * @Version: 1.0
 * Copyright: Copyright (c) 2019
 */
public class ProductAndConsumeMode {
    private Queue<Integer> queue = new LinkedList<>();
    private int max = 10;
    Object object = new Object();
    public static void main(String[] args) {
        ProductAndConsumeMode consumeMode = new ProductAndConsumeMode();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i <= 15; i++) {
                    try {
                        consumeMode.product(i);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i <= 15; i++) {
                    try {
                        consumeMode.consume();
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
    public void product(Integer num) throws InterruptedException {
        while (queue.size() >= 10) {
            synchronized (object) {
                object.wait();
            }
        }
        synchronized (object) {
            queue.add(num);
            System.out.println("添加元素 ：" + num);
            object.notify();
        }
    }

    public void consume() throws InterruptedException {
        while (queue.size() == 0) {
            synchronized (object) {
                object.wait();
            }
        }
        synchronized (object) {
            Integer num = queue.poll();
            System.out.println("移除元素 : " + num);
            object.notify();
        }
    }
}
