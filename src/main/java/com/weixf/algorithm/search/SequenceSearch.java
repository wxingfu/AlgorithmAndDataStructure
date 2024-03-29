package com.weixf.algorithm.search;

/**
 * @author wxf
 * @date 2020-10-29
 * @description
 */
public class SequenceSearch {

    public static void main(String[] args) {
        int[] arr = {1, 9, 11, -1, 34, 89};
        int index = seqSearch(arr, -11);
        if (index == -1) {
            System.out.println("没有找到到");
        } else {
            System.out.println("找到，下标为=" + index);
        }
    }

    /**
     * 顺序查找
     *
     * @param arr
     * @param key
     * @return
     */
    public static int seqSearch(int[] arr, int key) {

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key) {
                return i;
            }
        }
        return -1;
    }
}
