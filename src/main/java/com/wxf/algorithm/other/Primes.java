package com.wxf.algorithm.other;

public class Primes {

    public static void main(String[] args) {
        primes(20);
    }

    public static void primes(int n) {
        int count = 0;
        for (int i = 2; i <= n; i++) {
            int j = 2;
            for (; j <= (int) Math.sqrt(i); j++) {
                if (i % j == 0) {
                    break;
                }
            }
            if (j == (int) Math.sqrt(i) + 1) {
                System.out.println("质数：i= " + i);
                count++;
            }
        }
        System.out.println("质数个数：count= " + count);
    }
}
