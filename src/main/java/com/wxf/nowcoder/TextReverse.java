package com.wxf.nowcoder;

import java.util.Scanner;

public class TextReverse {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String s = sc.nextLine();
            // 1.以空格分隔字符串，放到数组中
            String[] strings = s.split(" ");
            // 2.定义一个字符串newString，用来存放新的字符串
            StringBuilder newStr = new StringBuilder();
            for (String arr : strings) {
                StringBuilder reverseStr = new StringBuilder(arr);
                // 实现翻转
                reverseStr.reverse();
                // 放入翻转之后的新的字符串
                newStr.append(reverseStr);
                newStr.append(" ");
            }
            System.out.println(newStr);
        }
    }
}
