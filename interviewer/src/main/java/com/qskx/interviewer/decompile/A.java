package com.qskx.interviewer.decompile;

/**
 * @ProjectName: springboot-advance
 * @ClassName: A
 * @Author: cg
 * @CreateDate: 2020-02-26 13:55
 * @Version: 1.0
 * Copyright: Copyright (c) 2020
 */
public class A {
    private B b = new B();

    public static void main(String[] args) {
        A a = new A();
        long num = 4321 ;

        long ret = a.b.test(num);

        System.out.println(ret);
    }
}

class B {

    private int a = 1234;

    static long C = 1111;

    public long test(long num) {
        long ret = this.a + num + C;
        return ret;
    }
}


