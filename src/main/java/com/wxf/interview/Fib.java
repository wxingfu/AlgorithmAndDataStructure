package com.wxf.interview;

public class Fib {

    public static void main(String[] args) {
        // int fib = fib(31);
        // System.out.println(fib);
        int i = fib3(10);
        System.out.println(i);
    }

    /**
     * 求斐波那契（Fibonacci）数列的第 n 项（即 F(N)）
     * 0<=n<=30
     *
     * @param n
     * @return
     */
    public static int fib(int n) {
        if (n >= 0 && n <= 30) {
            if (n == 0 || n == 1) {
                return n;
            } else {
                return fib(n - 1) + fib(n - 2);
            }
        } else {
            return 0;
        }
    }

    /**
     * 写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项（即 F(N)）。斐波那契数列的定义如下：
     * F(0) = 0,F(1)= 1
     * F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
     * 斐波那契数列由 0 和 1 开始，之后的斐波那契数就是由之前的两数相加而得出。
     * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
     * 0<=n<=100
     *
     * @param n
     * @return
     */
    public static int fib2(int n) {
        int a = 0, b = 1, sum;
        for (int i = 0; i < n; i++) {
            sum = (a + b) % 1000000007;
            a = b;
            b = sum;
        }
        return a;
    }

    public static int fib3(int n) {
        if (n == 0 || n == 1) {
            return n;
        } else {
            return fib(n - 1) + fib(n - 2);
        }
    }
}
