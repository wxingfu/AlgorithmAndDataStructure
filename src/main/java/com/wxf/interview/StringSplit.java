package com.wxf.interview;

import java.util.Scanner;

/**
 * 描述
 * •连续输入字符串，请按长度为8拆分每个字符串后输出到新的字符串数组；
 * •长度不是8整数倍的字符串请在后面补数字0，空字符串不处理。
 * <p>
 * 输入描述：
 * 连续输入字符串(输入多次,每个字符串长度小于100)
 * <p>
 * 输出描述：
 * 输出到长度为8的新字符串数组
 */
public class StringSplit {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String str = sc.nextLine();
            if (str.length() <= 100) {
                int len = str.length();
                int num = len / 8;
                // 余数
                int num2 = len % 8;

                String string = null;
                if (num <= 0) {
                    // <8
                    string = getString(8 - len);
                    System.out.println(str + string);
                } else {
                    // >8
                    if (num2 == 0) {
                        // 8的倍数
                        for (int i = 0; i < num * 8; i += 8) {
                            System.out.println(str.substring(i, i + 8));
                        }
                    } else {
                        // 不是8的倍数
                        for (int i = 0; i < num * 8; i += 8) {
                            System.out.println(str.substring(i, i + 8));
                        }
                        string = getString(8 - num2);
                        System.out.println(str.substring(len - num2, len) + string);
                    }
                }
            }
        }
    }

    private static String getString(int l) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < l; i++) {
            stringBuilder.append("0");
        }
        return stringBuilder.toString();
    }
}
