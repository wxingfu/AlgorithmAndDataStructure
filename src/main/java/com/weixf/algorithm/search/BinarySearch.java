package com.weixf.algorithm.search;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wxf
 * @date 2020-10-29
 * @description
 */
public class BinarySearch {

    public static void main(String[] args) {
        int[] arr = {1, 8, 10, 89, 1000, 1000, 1000, 1000, 1234};
        // int resIndex = binarySearch(arr, 0, arr.length - 1, 1000);
        List<Integer> idxList = binarySearch2(arr, 0, arr.length - 1, 1000);
        System.out.println(idxList);
        // int resIndex = binarySearch3(arr, 0, arr.length - 1, 1000);
        // System.out.println("resIndex=" + resIndex);
    }

    /**
     * 递归法实现二分查找
     *
     * @param arr
     * @param left
     * @param right
     * @param value
     * @return
     */
    public static int binarySearch(int[] arr, int left, int right, int value) {

        // 当 left > right 时，说明递归整个数组，但是没有找到
        if (left > right) {
            return -1;
        }

        int mid = (left + right) / 2;
        int midValue = arr[mid];

        if (value > midValue) { // 向右递归
            return binarySearch(arr, (mid + 1), right, value);
        } else if (value < midValue) { // 向左递归
            return binarySearch(arr, left, (mid - 1), value);
        } else { // 找到
            return mid;
        }
    }

    /**
     * 递归法实现二分查找
     * 找到多个重复值
     *
     * @param arr
     * @param left
     * @param right
     * @param value
     * @return
     */
    public static List<Integer> binarySearch2(int[] arr, int left, int right, int value) {

        // 当 left > right 时，说明递归整个数组，但是没有找到
        if (left > right) {
            return new ArrayList<Integer>();
        }

        int mid = (left + right) / 2;
        int midValue = arr[mid];

        if (value > midValue) { // 向右递归
            return binarySearch2(arr, (mid + 1), right, value);
        } else if (value < midValue) { // 向左递归
            return binarySearch2(arr, left, (mid - 1), value);
        } else { // 找到

            List<Integer> idxList = new ArrayList<>();
            // 向mid左边扫描是否有重复值
            int tmpIdx = mid - 1;
            while (tmpIdx >= 0 && arr[tmpIdx] == value) {
                idxList.add(tmpIdx);
                tmpIdx -= 1;
            }

            idxList.add(mid);

            // 向mid右边扫描是否有重复值
            tmpIdx = mid + 1;
            while (tmpIdx <= arr.length - 1 && arr[tmpIdx] == value) {
                idxList.add(tmpIdx);
                tmpIdx += 1;
            }
            return idxList;
        }
    }

    /**
     * 二分查找非递归实现
     *
     * @param arr
     * @param key
     * @return
     */
    public static int binarySearch3(int[] arr, int low, int high, int key) {

        if (key > arr[high] || key < arr[low] || low > high) {
            return -1;
        }
        int mid = 0;
        while (low <= high) {
            mid = (low + high) / 2;
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
