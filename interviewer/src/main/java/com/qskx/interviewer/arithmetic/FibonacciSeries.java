package com.qskx.interviewer.arithmetic;

/**
 * @ProjectName: springboot-advance
 * @ClassName: FibonacciSeries
 * @Author: cg
 * @CreateDate: 2020-03-16 19:06
 * @Version: 1.0
 * Copyright: Copyright (c) 2020
 */
public class FibonacciSeries {

    public static void main(String[] args) {
        System.out.println(fib(4));
    }

    public static int fib(int n) {
        if(n < 0 || n > 100) {
            return -1;
        }
        if(n == 0) return 0;
        if(n == 1) return 1;
        int sum = 1, preSum = 0, temp;
        for(int i = 2; i <= n; i++) {
            temp = sum;
            sum += preSum;
            preSum = temp;
        }
        return sum;
    }
}
