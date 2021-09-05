package com.wxf.leetcode.sword_finger_offer;

import java.util.HashMap;
import java.util.Map;

/**
 * 在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。
 * <p>
 * 示例:
 * s = "abaccdeff"
 * 返回 "b"
 * <p>
 * s = ""
 * 返回 " "
 * <p>
 * 链接：https://leetcode-cn.com/problems/di-yi-ge-zhi-chu-xian-yi-ci-de-zi-fu-lcof
 */
public class FirstUniqChar {

    public static void main(String[] args) {
        // String s = "loveleetcode";
        String s = "cc";
        char c = firstUniqChar3(s);
        System.out.println(c);
    }

    public static char firstUniqChar(String s) {
        int[] count = new int[26];
        char[] chars = s.toCharArray();
        for (char ch : chars) {
            count[ch - 'a']++;
        }
        for (char ch : chars) {
            if (count[ch - 'a'] == 1) {
                return ch;
            }
        }
        return ' ';
    }

    /**
     * 官解
     * 使用哈希表存储频数
     * <p>
     * 思路与算法
     * 我们可以对字符串进行两次遍历。
     * 在第一次遍历时，我们使用哈希映射统计出字符串中每个字符出现的次数。
     * 在第二次遍历时，我们只要遍历到了一个只出现一次的字符，
     * 那么就返回该字符，否则在遍历结束后返回空格。
     *
     * @param s
     * @return
     */
    public static char firstUniqChar2(String s) {
        Map<Character, Integer> frequency = new HashMap<Character, Integer>();
        for (int i = 0; i < s.length(); ++i) {
            char ch = s.charAt(i);
            frequency.put(ch, frequency.getOrDefault(ch, 0) + 1);
        }
        for (int i = 0; i < s.length(); ++i) {
            if (frequency.get(s.charAt(i)) == 1) {
                return s.charAt(i);
            }
        }
        return ' ';
    }

    public static char firstUniqChar3(String s) {
        Map<Character, Integer> frequency = new HashMap<Character, Integer>();
        for (int i = 0; i < s.length(); ++i) {
            char ch = s.charAt(i);
            Integer integer = frequency.get(ch);
            if (integer != null) {
                frequency.replace(ch, integer, integer + 1);
            } else {
                frequency.put(ch, 1);
            }
        }
        for (int i = 0; i < s.length(); ++i) {
            if (frequency.get(s.charAt(i)) == 1) {
                return s.charAt(i);
            }
        }
        return ' ';
    }
}
