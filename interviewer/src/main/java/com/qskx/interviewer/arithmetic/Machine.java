package com.qskx.interviewer.arithmetic;

/**
 * @ProjectName: springboot-advance
 * @ClassName: Machine
 * @Author: cg
 * @CreateDate: 2020-03-25 00:01
 * @Version: 1.0
 * Copyright: Copyright (c) 2020
 */
public class Machine {

    public static void main(String[] args) {
        System.out.println(movingCount(38, 15, 9));
//        System.out.println(spilitBit(18));
    }

    public static int movingCount(int m, int n, int k) {
        int count = 0;
        boolean flag = false;
        for(int i = 0; i < m; i++) {
            flag = false;
            for(int j = 0; j < n; j++) {
                int sum = spilitBit(i) + spilitBit(j);
                if(sum <= k) {
                    count++;
                    flag = true;
                } else {
                    if (k < 9 || (k == 9 && i >=9))
                    break;
                }
            }
            if (!flag) break;
        }
        return count;
    }

    public static int spilitBit(int num) {
        int bitSum = 0;
        do {
            bitSum += num % 10;
        } while ((num = num /10) > 0);
        return bitSum;
    }
}
