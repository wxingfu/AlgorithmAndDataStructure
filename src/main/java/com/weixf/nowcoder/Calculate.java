package com.weixf.nowcoder;

import java.util.Stack;

public class Calculate {

    public static void main(String[] args) {
        String s = "1+4*5-8/3";
        int calculate = calculate(s);
        System.out.println(calculate);
    }

    static int calculate(String str) {
        int length = str.length();
        if (length == 0) {
            return 0;
        }
        char[] chars = str.toCharArray();
        int len = chars.length;
        // 数字栈
        Stack<Integer> num = new Stack<>();
        // 运算符栈
        Stack<Character> op = new Stack<>();
        char operate;
        int num1 = 0;
        int num2 = 1;
        for (int i = 0; i < len; ++i) {
            if (chars[i] >= '0' && chars[i] <= '9') {
                // 数字
                num.push(chars[i] - '0');
            } else if (chars[i] == '+' || chars[i] == '-') {
                // 运算符 加减
                op.push(chars[i]);
            } else {
                // 运算符 乘除
                operate = chars[i];
                num1 = num.pop();
                num2 = chars[++i] - '0';
                if ('*' == operate) {
                    num.push(num1 * num2);
                } else if ('/' == operate) {
                    num.push(num1 / num2);
                }
            }
        }
        // 加减操作
        while (!op.empty()) {
            operate = op.pop();
            num1 = num.pop();
            num2 = num.pop();
            if ('+' == operate) {
                num.push(num1 + num2);
            } else if ('-' == operate) {
                num.push(num2 - num1);
            }
        }
        return num.peek();
    }
}
