package com.wxf.interview;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 * 输入一串用空格隔开的数字串，对于数字串的奇数位按升序排序，偶数位按降序排序。
 * 示例输入：
 * 4 6 2 3 6 7 8 1
 * 处理过程：
 * 奇数位：4 2 6 8 升序排序结果： 2 4 6 8
 * 偶数位：6 3 7 1 降序排序结果： 7 6 3 1
 * 结果输出：2 7 4 6 6 3 8 1
 * <p>
 * 排序结果
 * 4 6 2 3 6 7 8 1
 * 2 7 4 6 6 3 8 1
 */
public class NumStringSort {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            String numString = sc.nextLine();
            String[] str = numString.split(" ");
            int len = str.length;
            // 奇数
            Integer[] odd;
            // 偶数
            Integer[] even;
            // 偶数个数字
            if (len % 2 == 0) {
                odd = new Integer[len / 2];
                even = new Integer[len / 2];
            } else {
                // 奇数个数字
                odd = new Integer[len / 2 + 1];
                even = new Integer[len / 2];
            }
            // 分类存储
            int index_odd = 0;
            int index_even = 0;
            for (int i = 0; i < len; i++) {
                if (i % 2 == 0) {
                    odd[index_odd] = Integer.parseInt(str[i]);
                    index_odd++;
                } else {
                    even[index_even] = Integer.parseInt(str[i]);
                    index_even++;
                }
            }
            // 奇数升序
            Arrays.sort(odd);
            // 偶数降序
            Arrays.sort(even, Collections.reverseOrder());
            // 结果输出
            StringBuilder rs = new StringBuilder();
            for (int i = 0; i < index_even; i++) {
                rs.append(odd[i]).append(" ").append(even[i]).append(" ");
            }
            if (index_even != index_odd) {
                rs.append(odd[index_odd - 1]);
            }
            System.out.println(rs.toString().trim());
        }
    }
}
