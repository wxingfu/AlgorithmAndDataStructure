package com.weixf.algorithm.sort;

import java.util.Arrays;

/**
 * @author wxf
 * @date 2020-10-27
 * @description
 */
public class RadixSort {

    public static void main(String[] args) {
        int[] arr = new int[10];
        for (int i = 0; i < 10; i++) {
            arr[i] = (int) (Math.random() * 1000); // 生成一个[0, 100) 数
        }
        System.out.println("原数组：" + Arrays.toString(arr));
        radixSort(arr);
        System.out.println("排序后：" + Arrays.toString(arr));
    }

    public static void radixSort(int[] arr) {
        /*获取最大位数的元素*/
        int maxValue = arr[0];
        for (int value : arr) {
            if (maxValue < value) {
                maxValue = value;
            }
        }
        /*最大值元素的位数*/
        int maxLength = (maxValue + "").length();

        // 定义一个二维数组，表示10个桶, 每个桶就是一个一维数组
        // 说明
        // 1. 二维数组包含10个一维数组
        // 2. 为了防止在放入数的时候，数据溢出，则每个一维数组(桶)，大小定为arr.length
        // 3. 名明确，基数排序是使用空间换时间的经典算法
        int[][] bucket = new int[10][arr.length];

        // 为了记录每个桶中，实际存放了多少个数据,我们定义一个一维数组来记录各个桶的每次放入的数据个数
        // 比如：bucketElementCounts[0] , 记录的就是  bucket[0] 桶的放入数据个数
        int[] bucketElementCounts = new int[10];

        for (int i = 0, n = 1; i < maxLength; i++, n *= 10) {
            // (针对每个元素的对应位进行排序处理)， 第一次是个位，第二次是十位，第三次是百位..
            for (int value : arr) {
                // 取出每个元素的对应位的值
                int digitOfElement = value / n % 10;
                // 放入到对应的桶中
                bucket[digitOfElement][bucketElementCounts[digitOfElement]] = value;
                bucketElementCounts[digitOfElement]++;
            }
            // 按照这个桶的顺序(一维数组的下标依次取出数据，放入原来数组)
            int index = 0;
            // 遍历每一桶，并将桶中是数据，放入到原数组
            for (int k = 0; k < bucketElementCounts.length; k++) {
                // 如果桶中，有数据，我们才放入到原数组
                if (bucketElementCounts[k] != 0) {
                    // 循环该桶即第k个桶(即第k个一维数组), 放入
                    for (int l = 0; l < bucketElementCounts[k]; l++) {
                        // 取出元素放入到arr
                        arr[index++] = bucket[k][l];
                    }
                }
                // 第i+1轮处理后，需要将每个 bucketElementCounts[k] = 0
                bucketElementCounts[k] = 0;
            }
            System.out.println(Arrays.toString(arr));
        }

    }
}
