package com.weixf.algorithm.other;

/**
 * 统计所有小于非负整数 n 的质数的数量。
 */
public class CountPrimes {

    public static void main(String[] args) {
        int i = countPrimes(10);
        System.out.println(i);
    }

    public static int countPrimes(int n) {
        // 标记合数
        boolean[] composite = new boolean[n];
        int count = 0;// 统计质数的个数
        for (int i = 2; i < n; i++) {
            // 如果是合数就不需要统计
            if (composite[i])
                continue;
            count++;
            // 到这一步说明是质数，直接让他的2倍，
            // 3倍……都标记为合数
            for (int j = i; j < n; j += i)
                composite[j] = true;
        }
        return count;
    }
}
