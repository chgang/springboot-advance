package com.qskx.interviewer.arithmetic;

/**
 * @ProjectName: springboot-advance
 * @ClassName: ReplicaNum
 * @Author: cg
 * @CreateDate: 2020-02-15 20:15
 * @Version: 1.0
 * Copyright: Copyright (c) 2020
 */
public class ReplicaNum {
    public static void main(String[] args) {
        int[] nums = {3,1,3,4,2};
        System.out.println(findDuplicate(nums));
    }

    public static int findDuplicate(int[] nums) {
        int len = nums.length;
        if(nums.length <= 1) {
            throw new RuntimeException();
        }
        int[] temp = new int[len];
        int replica = -1;
        for(int i = 0; i < len; i++) {
            if(temp[nums[i]] == 0) {
                temp[nums[i]] = nums[i];
            } else {
                replica = nums[i];
            }
        }
        return replica;
    }
}
