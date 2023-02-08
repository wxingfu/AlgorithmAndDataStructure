package com.wxf.datastructure.heap;

import java.util.Arrays;

public class MinHeap {

    public static void main(String[] args) {
        // test1();
        test2();


    }

    private static void test2() {
        // 首尾互换，删尾，首下沉
        int[] arr = new int[]{1, 2, 3, 7, 5, 4, 6, 10, 9, 8};

        int arrSize = arr.length;

        System.out.println(arr[0]);
        System.out.println(arr[arrSize - 1]);

        int tmp = arr[0];
        arr[0] = arr[arrSize - 1];
        arr[arrSize - 1] = tmp;
        System.out.println(Arrays.toString(arr));

        int arr2Size = arrSize - 1;
        int[] arr2 = new int[arr2Size];

        System.arraycopy(arr, 0, arr2, 0, arr2Size);

        System.out.println(Arrays.toString(arr2));

        int idx = 0;
        while (idx < arr2Size && (2 * idx + 1) <= arr2Size && (2 * idx + 2) <= arr2Size) {
            int top = arr2[idx];
            int a = arr2[2 * idx + 1];
            int b = arr2[2 * idx + 2];

            if (a < b) {
                arr2[idx] = a;
                arr2[2 * idx + 1] = top;
                idx = 2 * idx + 1;
            } else {
                arr2[idx] = b;
                arr2[2 * idx + 2] = top;
                idx = 2 * idx + 2;
            }
        }
        System.out.println(Arrays.toString(arr2));
    }

    private static void test1() {
        // 尾插，上浮
        int[] arr = new int[]{1, 5, 3, 7, 8, 4, 6, 10, 9};
        System.out.println(arr[(arr.length - 1) / 2 - 1]);
        int[] arr2 = new int[arr.length + 1];

        System.arraycopy(arr, 0, arr2, 0, arr.length);

        arr2[arr.length] = 2;
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(arr2));

        int idx = arr2.length - 1;
        while (idx > 1) {
            int a = arr2[idx];
            int b = a;
            if (idx % 2 == 0) {
                b = arr2[(idx - 1) / 2];
            } else {
                b = arr2[idx / 2];
            }
            if (a < b) {
                arr2[idx] = b;
                if (idx % 2 == 0) {
                    arr2[(idx - 1) / 2] = a;
                    idx = (idx - 1) / 2;
                } else {
                    arr2[idx / 2] = a;
                    idx = idx / 2;
                }
            }
        }
        System.out.println(Arrays.toString(arr2));
    }
}
