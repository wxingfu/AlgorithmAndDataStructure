package com.weixf.base;

/*
 *
 * @author weixf
 * @date 2023-02-03
 */
public class MathBase {

    public static void main(String[] args) {
        int result = gcd(120, 18);
        System.out.println(result);
    }


    /**
     * 最大公约数求解
     * gcd(a,b) = gcd(b,a mod b) (不妨设a>b 且r=a mod b ,r不为0)
     * 欧几里得算法又称辗转相除法，是指用于计算两个非负整数a，b的最大公约数
     */
    public static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }


}
