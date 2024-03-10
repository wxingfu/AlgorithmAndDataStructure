package com.weixf.nowcoder;

import java.util.Scanner;

/**
 * 对字符串中的所有单词进行倒排。
 * <p>
 * 说明：
 * <p>
 * 1、构成单词的字符只有26个大写或小写英文字母；
 * <p>
 * 2、非构成单词的字符均视为单词间隔符；
 * <p>
 * 3、要求倒排后的单词间隔符以一个空格表示；
 * 如果原字符串中相邻单词间有多个间隔符时，
 * 倒排转换后也只允许出现一个空格间隔符；
 * <p>
 * 4、每个单词最长20个字母；
 */
public class WordReverse {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String s = sc.nextLine();
            // 替换非字母字符为空格
            s = s.replaceAll("[^A-Za-z]", " ");
            String[] strings = s.split(" ");
            StringBuilder str = new StringBuilder();
            for (int i = strings.length - 1; i >= 0; i--) {
                str.append(strings[i]).append(" ");
            }
            System.out.println(str.toString().trim());
        }
    }
}
