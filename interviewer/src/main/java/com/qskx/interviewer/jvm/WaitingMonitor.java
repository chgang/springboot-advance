package com.qskx.interviewer.jvm;

/**
 * @ProjectName: springboot-advance
 * @ClassName: WaitingMonitor
 * @Author: cg
 * @CreateDate: 2020-03-19 16:59
 * @Version: 1.0
 * Copyright: Copyright (c) 2020
 */
public class WaitingMonitor {
    Thread thread = new Thread(() -> {
        synchronized (this) {
            System.out.println(Thread.currentThread().getName());
        }
    });
}
