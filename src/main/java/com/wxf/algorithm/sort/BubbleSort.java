package com.wxf.algorithm.sort;

import java.util.Arrays;

/**
 * @author wxf
 * @date 2020-10-27
 * @description
 */
public class BubbleSort {
    public static void main(String[] args) {
        System.out.println("--------------基本冒泡排序-------------------");
        int[] arr = new int[10];
        for (int i = 0; i < 10; i++) {
            arr[i] = (int) (Math.random() * 100); // 生成一个[0, 100) 数
        }
        // int[] arr = {36, 49, 24, 77, 96, 38, 31, 13, 86, 20};
        System.out.println("原数组：" + Arrays.toString(arr));
        bubbleSort(arr);
        //
        System.out.println("---------------冒泡排序优化1------------------");
        int[] arr1 = new int[10];
        for (int i = 0; i < 10; i++) {
            arr1[i] = (int) (Math.random() * 100); // 生成一个[0, 100) 数
        }
        // int[] arr1 = {36, 49, 24, 77, 96, 38, 31, 13, 86, 20};
        System.out.println("原数组：" + Arrays.toString(arr1));
        bubbleSort1(arr1);
        //
        System.out.println("---------------冒泡排序优化2------------------");
        int[] arr2 = new int[10];
        for (int i = 0; i < 10; i++) {
            arr2[i] = (int) (Math.random() * 100); // 生成一个[0, 100) 数
        }
        // int[] arr2 = {36, 49, 24, 77, 96, 38, 31, 13, 86, 20};
        System.out.println("原数组：" + Arrays.toString(arr2));
        bubbleSort2(arr2);

        System.out.println("---------------冒泡排序优化3------------------");
        int[] arr3 = new int[10];
        for (int i = 0; i < 10; i++) {
            arr3[i] = (int) (Math.random() * 100); // 生成一个[0, 100) 数
        }
        // int[] arr3 = {36, 49, 24, 77, 20, 38, 31, 86, 96, 13};
        System.out.println("原数组：" + Arrays.toString(arr3));
        bubbleSort3(arr3);
    }

    public static void bubbleSort(int[] arr) {
        int temp, count = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    count += 1;
                }
                // System.out.printf("第%d趟第%d次排序结果：", i + 1, j + 1);
                // System.out.println(Arrays.toString(arr));
            }
        }
        System.out.println("总交换次数：" + count);
        System.out.println("最终排序结果：" + Arrays.toString(arr));

    }

    /**
     * 优化1：加标志位，标记已经有序的不用在进行比较
     *
     * @param arr
     */
    public static void bubbleSort1(int[] arr) {
        int temp, count = 0;
        int flag = 1;
        for (int i = 0; i < arr.length - 1; i++) {
            if (flag == 1) {
                flag = 0;
                for (int j = 0; j < arr.length - 1 - i; j++) {
                    if (arr[j] > arr[j + 1]) {
                        temp = arr[j];
                        arr[j] = arr[j + 1];
                        arr[j + 1] = temp;
                        count += 1;
                        flag = 1;
                    }
                    // System.out.printf("第%d趟第%d次排序结果：", i + 1, j + 1);
                    // System.out.println(Arrays.toString(arr));
                }
            }
        }
        System.out.println("总交换次数：" + count);
        System.out.println("最终排序结果：" + Arrays.toString(arr));
    }

    /**
     * 优化2：记录已经排好序的位置，下一趟直接从这个位置开始比较
     *
     * @param arr
     */
    public static void bubbleSort2(int[] arr) {
        int temp, count = 0, idx = 0, len = arr.length - 1;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < len - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    count += 1;
                    idx = j;
                }
                // System.out.printf("第%d趟第%d次排序结果：", i + 1, j + 1);
                // System.out.println(Arrays.toString(arr));
            }
            len = idx;
        }
        System.out.println("总交换次数：" + count);
        System.out.println("最终排序结果：" + Arrays.toString(arr));

    }

    /**
     * 优化3：从两端比较，正向扫描找到最大值交换到最后，反向扫描找到最小值交换到最前面
     *
     * @param arr
     */
    public static void bubbleSort3(int[] arr) {
        int temp;
        int count = 0;
        int idx = 0;
        int len = arr.length - 1;
        int n = 0;

        for (int i = 0; i < arr.length - 1; i++) {
            idx = 0;
            // 正向寻找最大值
            // 正向寻找最大值
            for (int j = n; j < len; j++) {
                if (arr[j] > arr[j + 1]) {
                    // 交换
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    idx = j;// 交换元素，记录最后一次交换的位置
                    count++;
                }
                // System.out.printf("第%d趟第%d次排序结果：", i + 1, j + 1);
                // System.out.println(Arrays.toString(arr));
            }
            len = idx;
            // 反向寻找最小值
            for (int k = len; k > n; k--) {
                int tmp = arr[k];
                arr[k] = arr[k - 1];
                arr[k - 1] = tmp;
            }
            n++;
        }
        System.out.println("总交换次数：" + count);
        System.out.println("最终排序结果：" + Arrays.toString(arr));

    }
}
