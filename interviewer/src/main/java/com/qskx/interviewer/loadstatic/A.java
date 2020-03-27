package com.qskx.interviewer.loadstatic;

/**
 * @ProjectName: springboot-advance
 * @ClassName: A
 * @Author: cg
 * @CreateDate: 2020-02-25 13:57
 * @Version: 1.0
 * Copyright: Copyright (c) 2020
 */
public class A {

        static int a = 0 ;
        static {
            a = 1;
            b = 1;
        }
        static int b = 0;

        public static void main(String[] args) {
            System.out.println(a);
            System.out.println(b);
            B bo = new B();
            System.out.println(B.b);
            System.out.println(B.a);
        }

    }
