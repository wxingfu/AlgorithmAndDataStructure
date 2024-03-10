package com.weixf.nowcoder;

import java.util.Scanner;

/**
 * 描述
 * 输入一个整数，将这个整数以字符串的形式逆序输出
 * 程序不考虑负数的情况，若数字含有0，则逆序形式也含有0，如输入为100，则输出为001
 * <p>
 * <p>
 * 输入描述：
 * 输入一个int整数
 * <p>
 * 输出描述：
 * 将这个整数以字符串的形式逆序输出
 */
public class NumReverse {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            Integer num = sc.nextInt();
            String s = num.toString();
            char[] chars = s.toCharArray();
            StringBuilder sb = new StringBuilder();
            for (int i = chars.length - 1; i >= 0; i--) {
                sb.append(chars[i]);
            }
            System.out.println(sb);
        }
    }
}
