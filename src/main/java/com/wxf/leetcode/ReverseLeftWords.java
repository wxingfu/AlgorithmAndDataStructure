package com.wxf.leetcode;

/**
 * 字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。
 * 请定义一个函数实现字符串左旋转操作的功能。
 * 比如，输入字符串"abcdefg"和数字2，该函数将返回左旋转两位得到的结果"cdefgab"。
 * <p>
 * 示例 1：
 * 输入: s = "abcdefg", k = 2
 * 输出:"cdefgab"
 * 示例 2：
 * <p>
 * 输入: s = "lrloseumgh", k = 6
 * 输出:"umghlrlose"
 * <p>
 * 链接：https://leetcode-cn.com/problems/zuo-xuan-zhuan-zi-fu-chuan-lcof
 */
public class ReverseLeftWords {
    public static void main(String[] args) {
        String s = reverseLeftWords("lrloseumgh", 6);
        //umghlrlose
        System.out.println(s);
    }

    public static String reverseLeftWords(String s, int n) {

        // 方法一
        /*return s.substring(n) + s.substring(0, n);*/

        // 方法二 StringBuilder
        /*StringBuilder res = new StringBuilder();
        for(int i = n; i < s.length(); i++)
            res.append(s.charAt(i));
        for(int i = 0; i < n; i++)
            res.append(s.charAt(i));
        return res.toString();*/

        // 方法二 优化 取余
        /*StringBuilder res = new StringBuilder();
        for (int i = n; i < n + s.length(); i++) {
            int mod = i % s.length();
            res.append(s.charAt(mod));
        }
        return res.toString();*/

        // 方法三 字符串拼接，只使用String
        String res = "";
        for (int i = n; i < s.length(); i++)
            res += s.charAt(i);
        for (int i = 0; i < n; i++)
            res += s.charAt(i);
        return res;
    }
}
