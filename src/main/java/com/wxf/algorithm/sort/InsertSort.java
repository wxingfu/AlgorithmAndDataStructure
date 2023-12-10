package com.wxf.algorithm.sort;

import java.util.Arrays;

/**
 * @author wxf
 * @date 2020-10-27
 * @description
 */
public class InsertSort {

    public static void main(String[] args) {
        int[] arr = new int[10];
        for (int i = 0; i < 10; i++) {
            arr[i] = (int) (Math.random() * 100); // 生成一个[0, 100) 数
        }
        System.out.println("原数组：" + Arrays.toString(arr));
        insertSort(arr);
        System.out.println("排序后：" + Arrays.toString(arr));
    }

    /**
     * 基本思想：把n个待排序的元素看成为一个有序表和一个无序表，
     * 开始时有序表中只包含一个元素，无序表中包含有n-1个元素，
     * 排序过程中每次从无序表中取出第一个元素，
     * 把它的排序码依次与有序表元素的排序码进行比较，
     * 将它插入到有序表中的适当位置，使之成为新的有序表。
     *
     * @param arr
     */
    public static void insertSort(int[] arr) {

        int insertVal = 0;
        int insertIndex = 0;
        // 使用for循环来把代码简化
        for (int i = 1; i < arr.length; i++) {
            // 定义待插入的数
            insertVal = arr[i];
            insertIndex = i - 1; // 即arr[1]的前面这个数的下标
            // 给insertVal 找到插入的位置
            // 说明
            // 1. insertIndex >= 0 保证在给insertVal 找插入位置，不越界
            // 2. insertVal < arr[insertIndex] 待插入的数，还没有找到插入位置
            // 3. 就需要将 arr[insertIndex] 后移
            while (insertIndex >= 0 && insertVal < arr[insertIndex]) {
                arr[insertIndex + 1] = arr[insertIndex];// arr[insertIndex]
                insertIndex--;
            }
            // 当退出while循环时，说明插入的位置找到, insertIndex + 1
            if (insertIndex + 1 != i) {
                arr[insertIndex + 1] = insertVal;
            }

            System.out.println(Arrays.toString(arr));
        }

    }
}
