package com.qskx.interviewer.stringconstant;

/**
 * @ProjectName: springboot-advance
 * @ClassName: SConstant
 * @Author: cg
 * @CreateDate: 2020-02-25 23:32
 * @Version: 1.0
 * Copyright: Copyright (c) 2020
 */
public class SConstant {

    public static void main(String[] args) {
        //  此时生成了四个对象 常量池中的"1" + 2个堆中的"1" + s3指向的堆中的对象（注此时常量池不会生成"11"）
        String s3 = new String("1") + new String("1");
        s3.intern();
        String s4 = "11";
        System.out.println(s3 == s4);

    }
}
