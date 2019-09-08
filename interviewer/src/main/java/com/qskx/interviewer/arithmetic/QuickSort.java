package com.qskx.interviewer.arithmetic;

import java.util.Arrays;
import java.util.BitSet;

/**
 * @ProjectName: springboot-advance
 * @ClassName: QuickSort
 * @Author: cg
 * @CreateDate: 2019-09-08 11:31
 * @Version: 1.0
 * Copyright: Copyright (c) 2019
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {23, 13, 22, 45, 76, 34, 3, 17};
        sort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr, int low, int high) {
        if (low >= high) {
            return;
        }
        int i = low;
        int j = high;
        int mid = arr[low];
        while (i < j) {
            while(i<j && mid < arr[j]) {
                j--;
            }
            if (i < j) {
                arr[i] = arr[j];
            }
            while (i< j && mid > arr[i]) {
                i++;
            }
            if (i < j) {
                arr[j] = arr[i];
            }
        }
        arr[i] = mid;
        sort(arr, low, i -1);
        sort(arr, i + 1, high);
    }
}
