package com.weixf.leetcode;

import java.util.Arrays;

/**
 * 设计一个算法，找出数组中最小的k个数。以任意顺序返回这k个数均可。
 * <p>
 * 示例：
 * 输入： arr = [1,3,5,7,2,4,6,8], k = 4
 * 输出： [1,2,3,4]
 * <p>
 * 链接：https://leetcode-cn.com/problems/smallest-k-lcci
 */
public class SmallestK {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 3, 5, 7, 2, 4, 6, 8};
        int[] ints = smallestK(arr, 4);
        for (int anInt : ints) {
            System.out.print(anInt + " ");
        }
    }

    public static int[] smallestK(int[] arr, int k) {
        int[] result = new int[k];
        Arrays.sort(arr);
        System.arraycopy(arr, 0, result, 0, k);
        return result;
    }
}
