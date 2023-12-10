package com.wxf.nowcoder;

import java.util.Scanner;
import java.util.Stack;

public class Compute {

    static int pos;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String data = sc.nextLine();
            int sum = compute(data);
            System.out.println(sum);
        }
    }

    public static int compute(String data) {
        Stack<Integer> val = new Stack<>();
        int num = 0;
        char opt = '+';
        while (pos < data.length()) {
            // 遇到括号，开始递归 ，从括号里面开始算，消消乐
            if (data.charAt(pos) == '{' || data.charAt(pos) == '[' || data.charAt(pos) == '(') {
                pos++;
                num = compute(data);
            }

            // 得到数字num
            while (pos < data.length() && Character.isDigit(data.charAt(pos))) {
                // 这步操作是 num是几位就得到几位的num。
                num = num * 10 + data.charAt(pos) - '0';
                pos++;
            }

            // 按照题目意思，正常合法的表达式字符串的话，数字后面一定会是跟运算符。
            // 所以这里判断运算符
            // 这一步的终极目的是把栈里面全部变成+ 号的运算，
            switch (opt) {
                case '+':
                    val.push(num);
                    break;
                //- 号的时候变成负数
                case '-':
                    val.push(-num);
                    break;
                // 乘号的时候出栈先做乘法运算后把得到的结果 再入栈
                case '*':
                    val.push(val.pop() * num);
                    break;
                // 同上面的乘号
                case '/':
                    val.push(val.pop() / num);
                    break;
            }
            num = 0;
            if (pos < data.length()) {
                // 数字后面有可能是运算符或者括号
                // 如果下面没有被break，这里opt是取得的下一个运算符
                opt = data.charAt(pos);
                // 如果这里是括号，就break，那么opt的值会在一开始被初始化成+
                if (data.charAt(pos) == '}' || data.charAt(pos) == ']' || data.charAt(pos) == ')') {
                    pos++;
                    break;
                }
            }
            pos++;
        }
        int sum = 0;
        while (!val.empty()) {
            sum += val.pop();
        }
        return sum;
    }
}
