package com.qskx.interviewer.arithmetic;

import java.util.Arrays;

/**
 * @ProjectName: springboot-advance
 * @ClassName: HeapSort
 * @Author: cg
 * @CreateDate: 2019-09-16 22:38
 * @Version: 1.0
 * Copyright: Copyright (c) 2019
 */
public class HeapSort {
    public static void main(String[] args) {
        int[] arr = {3, 79, 35, 12, 45, 90, 29};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void sort(int[] arr) {
        // 数组最后一个元素下表
        int lastIndex = arr.length - 1;
        // 最后一个非叶子节点下标
        int index = (lastIndex - 1) >> 1;
        for (int i = index; i >=0; i--) {
            maxHeapAdjust(arr, i, lastIndex);
        }
        for (int i = lastIndex; i > 0; i--) {
            swap(arr, 0, i);
            maxHeapAdjust(arr, 0, i - 1);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static void maxHeapAdjust(int[] arr, int index, int len) {
        // index左节点
        int left = (index << 1) + 1;
        if (left > len) {
            return;
        }
        // index 右节点
        int right = left + 1;
        int maxIndex = left;
        if (right <= len && arr[right] > arr[left]) {
            maxIndex = right;
        }
        if (arr[maxIndex] > arr[index]) {
            swap(arr, index, maxIndex);
            // 交换后子节点和孙节点比较
            maxHeapAdjust(arr, maxIndex, len);
        }
    }
}
