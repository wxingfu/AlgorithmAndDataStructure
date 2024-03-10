package com.weixf.algorithm.search;

/**
 * @author wxf
 * @date 2020-10-29
 * @description
 */
public class InsertValueSearch {
    public static void main(String[] args) {
        int[] arr = new int[100];
        for (int i = 0; i < 100; i++) {
            arr[i] = i + 1;
        }
        int idx = insertValueSearch2(arr, 0, arr.length - 1, 50);
        System.out.println(idx);
    }

    /**
     * 插值查找
     * 要求数组有序
     *
     * @param arr
     * @param low
     * @param high
     * @param key
     * @return
     */
    public static int insertValueSearch(int[] arr, int low, int high, int key) {

        if (low > high || key > arr[high] || key < arr[low]) {
            return -1;
        }

        int mid = low + (high - low) * (key - arr[low]) / (arr[high] - arr[low]);
        int midValue = arr[mid];
        if (midValue < key) {
            return insertValueSearch(arr, (mid + 1), high, key);
        } else if (midValue > key) {
            return insertValueSearch(arr, low, (mid - 1), key);
        } else {
            return mid;
        }
    }

    public static int insertValueSearch2(int[] arr, int low, int high, int key) {

        if (key > arr[high] || key < arr[low] || low > high) {
            return -1;
        }
        int mid = 0;
        while (low <= high) {
            mid = low + (high - low) * (key - arr[low]) / (arr[high] - arr[low]);
            if (arr[mid] > key) {
                high = mid - 1;
            } else if (arr[mid] < key) {
                low = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
