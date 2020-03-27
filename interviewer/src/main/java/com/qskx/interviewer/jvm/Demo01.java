package com.qskx.interviewer.jvm;

import java.util.concurrent.TimeUnit;

/**
 * @ProjectName: springboot-advance
 * @ClassName: Demo01
 * @Author: cg
 * @CreateDate: 2020-03-12 20:10
 * @Version: 1.0
 * Copyright: Copyright (c) 2020
 */
public class Demo01 {

    public static void main(String[] args) throws InterruptedException {
        TimeUnit.SECONDS.sleep(30);
        while (true) {
            loadData();
        }
    }

    private static void loadData() throws InterruptedException {
        byte[] data = null;
        for (int i = 0; i < 4; i++) {
            data = new byte[10 << 20];
        }
        data = null;
        byte[] data1 = new byte[10 << 20];
        byte[] data2 = new byte[10 << 20];
        byte[] data3 = new byte[10 << 20];
        data3 = new byte[10 << 20];
//        TimeUnit.SECONDS.sleep(1);
    }
}
