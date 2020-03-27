package com.qskx.interviewer.decompile;

/**
 * @ProjectName: springboot-advance
 * @ClassName: FinallyTest
 * @Author: cg
 * @CreateDate: 2019-12-04 15:57
 * @Version: 1.0
 * Copyright: Copyright (c) 2019
 */
public class FinallyTest {

    private static String s = "124";
    private static final int i = 3;
//    static int i3 = 8;

    public static int test1(int a){
        try{
            a+=20;
            return a;
        } finally {
            a+=30;
            return a;
        }
    }
    public static int test2(int b){
        try{
            b+=20;
            return b;
        }finally {
            b+=30;
            System.out.println(b);
        }
    }

    public static String str() {
        int i1 = 456;
        Integer i2 = new Integer(123);
        String v = "121";
        v = "123" + i;
        int a = i + 4;
        return v;
    }

    public static void main(String[] args) {
//        System.out.println("开始。。。。。。");
//        str();
//        while (true) {
//
//        }
//        System.out.println(str());
        System.out.println(test1(10));
        System.out.println(test2(10));
    }
}
