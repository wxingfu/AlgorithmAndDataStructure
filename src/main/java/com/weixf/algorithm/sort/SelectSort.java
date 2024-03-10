package com.weixf.algorithm.sort;

import java.util.Arrays;

/**
 * @author wxf
 * @date 2020-10-27
 * @description
 */
public class SelectSort {

    public static void main(String[] args) {
        int[] arr = new int[10];
        for (int i = 0; i < 10; i++) {
            arr[i] = (int) (Math.random() * 100); // 生成一个[0, 100) 数
        }
        System.out.println("原数组：" + Arrays.toString(arr));
        selectSort(arr);
        System.out.println("排序后：" + Arrays.toString(arr));
    }

    /**
     * 基本思想：第一趟将序列中值最小的元素与第一位元素位置交换
     * 第二趟剩余元素序列重复第一趟操作
     * 第三趟剩余元素序列重复第一趟操作
     *
     * @param arr
     */
    public static void selectSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int idxOfMinValue = i;
            int minValue = arr[idxOfMinValue];
            for (int j = i + 1; j < arr.length; j++) {
                if (minValue > arr[j]) {
                    minValue = arr[j];
                    idxOfMinValue = j;
                }
            }
            if (idxOfMinValue != i) {
                arr[idxOfMinValue] = arr[i];
                arr[i] = minValue;
            }
            System.out.println(Arrays.toString(arr));
        }
    }
}
