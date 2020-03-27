package com.qskx.interviewer.genericity;

import java.util.ArrayList;
import java.util.List;

/**
 * @ProjectName: springboot-advance
 * @ClassName: ListTest
 * @Author: cg
 * @CreateDate: 2020-03-19 08:15
 * @Version: 1.0
 * Copyright: Copyright (c) 2020
 */
public class ListTest {

    public static void main(String[] args) {
        List list = new ArrayList();
        list.add(1);
        list.add("1234");
        System.out.println(list.toString());
    }
}
