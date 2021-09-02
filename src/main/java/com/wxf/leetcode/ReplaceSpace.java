package com.wxf.leetcode;

/**
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 * <p>
 * 示例 1：
 * 输入：s = "We are happy."
 * 输出："We%20are%20happy."
 * <p>
 * 链接：https://leetcode-cn.com/problems/ti-huan-kong-ge-lcof
 */
public class ReplaceSpace {
    public static void main(String[] args) {
        String s = replaceSpace("We are happy.");
        System.out.println(s);
    }

    public static String replaceSpace(String s) {
        StringBuilder res = new StringBuilder();
        for (Character c : s.toCharArray()) {
            if (c == ' ') {
                res.append("%20");
            } else res.append(c);
        }
        return res.toString();
        // return s.replace(" ", "%20");
    }
}
