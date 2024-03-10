package com.weixf.leetcode.sword_finger_offer;

/**
 * 写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项。斐波那契数列的定义如下：
 * <p>
 * F(0) = 0,   F(1) = 1
 * F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
 * 斐波那契数列由 0 和 1 开始，之后的斐波那契数就是由之前的两数相加而得出。
 * <p>
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 */
public class FibonacciSequence {
    public static void main(String[] args) {
        int fib = fib(10);
        System.out.println(fib);
    }

    public static int fib(int n) {
        // 边界判断
        if (n == 0) {
            return 0;
        }
        // 用于存储第 0 到 n 个数对应的值
        int[] dp = new int[n + 1];
        // 先定义好第一个数
        dp[0] = 0;
        // 再定义好第二个数
        dp[1] = 1;
        // 计算大于 0 和大于 1 的值
        for (int i = 2; i <= n; i++) {
            // 当遇到之前计算过的数时，将不再递归往下找，直接用记忆化结果
            dp[i] = dp[i - 1] + dp[i - 2];
            // 题目要求进行取模处理
            dp[i] %= 1000000007;
        }
        // 返回结果
        return dp[n];
    }
}
