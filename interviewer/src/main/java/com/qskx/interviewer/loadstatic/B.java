package com.qskx.interviewer.loadstatic;

/**
 * @ProjectName: springboot-advance
 * @ClassName: B
 * @Author: cg
 * @CreateDate: 2020-02-25 13:59
 * @Version: 1.0
 * Copyright: Copyright (c) 2020
 */
public class B {

    static int a = 2;
    static int b = 5;
    static {
        a = 10;
        System.out.println(b);
    }
}
