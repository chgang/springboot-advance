package com.qskx.interviewer.arithmetic;

/**
 * @ProjectName: springboot-advance
 * @ClassName: BinarySearch
 * @Author: cg
 * @CreateDate: 2019-09-08 14:42
 * @Version: 1.0
 * Copyright: Copyright (c) 2019
 */
public class BinarySearch {

    public static void main(String[] args) {
        int[] arr = {34, 17, 5, 98, 23, 45, 8};
        System.out.println(query(arr, 8));
    }

    public static int query(int[] arr, int num) {
        QuickSort.sort(arr, 0, arr.length - 1);
        int mid = arr.length/2;
        int low = 0;
        int high = arr.length -1;
        while (low <= high) {
            if (num < arr[mid]) {
                high = mid - 1;
                mid = (low + high)/2;
            }
            if (num == arr[mid]) {
                return 1;
            }
            if (num > arr[mid]) {
                low = mid + 1;
                mid = (low + high)/2;
            }
        }
        return  -1;
    }
}
