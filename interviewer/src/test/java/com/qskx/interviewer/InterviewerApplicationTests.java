package com.qskx.interviewer;

import org.junit.Test;

public class InterviewerApplicationTests {

    @Test
    public void contextLoads() {
        test1(90, 1000000007);
        test2(90, 1000000007);
    }

    public void test1(int n, int p) {
        long rem = 1, x = 3;
        for (int a = n / 3 - 1; a > 0; a /= 2) {
            if (a % 2 == 1) rem = (rem * x) % p;
            x = (x * x) % p;
        }
        System.out.println(rem);
    }

    public void test2(int n, int p) {
        int index;
        if(n % 3 == 1) {
            index = n/3 - 1;
        } else {
            index = n/3;
        }
        long remainder = 1;
        for(int i = 0; i < index; i++) {
            remainder = (3 * remainder) % 1000000007;
        }
        System.out.println(remainder);
    }

}
