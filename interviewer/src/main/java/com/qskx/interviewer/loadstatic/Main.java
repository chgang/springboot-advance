package com.qskx.interviewer.loadstatic;

/**
 * @ProjectName: springboot-advance
 * @ClassName: Main
 * @Author: cg
 * @CreateDate: 2020-02-25 14:04
 * @Version: 1.0
 * Copyright: Copyright (c) 2020
 */
public class Main {
    static Class[] classArray;

    static {
            classArray = new Class[]{
                        MyClass1.class//这样引用该类，必然需要将该类加载到虚拟机中，（反射机制）
                };
//        try {
//            classArray = new Class[] {Class.forName("com.qskx.interviewer.loadstatic.MyClass1")};
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
    }

    {
        System.out.println("非静态代码块");
    }

    public static void main(String[] args){
        System.out.println("hello word");
    }
}

