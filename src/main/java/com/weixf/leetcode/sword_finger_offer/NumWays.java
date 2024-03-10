package com.weixf.leetcode.sword_finger_offer;

/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
 * <p>
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 * <p>
 * 0 <= n <= 100
 */
public class NumWays {
    public static void main(String[] args) {
        int i = numWays(100);
        System.out.println(i);
    }

    public static int numWays(int n) {
        // 新建一个长度为 n+1 的数组，用于在递归时存储 memo(0) 到 memo(n) 的值，重复遇到某数字时则直接从数组取用，避免大量重复的递归计算。例如 memo[0]表示从第 0 级跳到第 n 级的方式数量
        long[] memo = new long[n + 1];
        // 得到从第 0 级跳到第 n 级的方式数量
        return (int) helper(0, n, memo);
    }

    public static long helper(int i, int n, long[] memo) {

        if (i > n) { // 边界处理
            return 0;
        }

        if (i == n) { // 相当于原地起跳，只有一种方式
            return 1;
        }
        if (memo[i] > 0) { // 数组中存储了结果，直接拿来用
            return memo[i];
        }
        // 无论有多少级台阶，青蛙到最后都面临两种情况：要么跳 1 级台阶的高度，要么跳 2 级台阶的高度。
        // 假设跳上 n 级台阶总计有 memo(n) 种跳法，那么跳到 n - 2 级台阶有 memo(n-2) 种跳法，跳到 n - 1  级台阶有 memo(n-1) 种跳法，并且  memo(n) = memo(n-2) + memo(n-1)。
        // memo[i]表示从第 i 级跳到第 n 级的方式数量
        memo[i] = helper(i + 1, n, memo) + helper(i + 2, n, memo);

        // 取模返回结果
        return memo[i] % 1000000007;
    }
}
