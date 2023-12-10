package com.wxf.nowcoder.huawei_od;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * 水库蓄水问题
 * <a href="https://blog.csdn.net/choukai0932/article/details/128539994">...</a>
 */
public class OD0005 {

    public static void main(String[] args) {
        // 处理输入
        Scanner in = new Scanner(System.in);
        // 转为数组
        List<Integer> height = Arrays.stream(in.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        int left = -1;
        int right = -1;
        int l = 0, r = height.size() - 1;
        int ans = 0;
        while (l < r) {
            int area = Math.min(height.get(l), height.get(r)) * (r - l);
            if (area > ans) {
                ans = area;
                left = l;
                right = r;
            }
            if (height.get(l) <= height.get(r)) {
                ++l;
            } else {
                --r;
            }
        }
        System.out.println(ans);
        System.out.print(left);
        System.out.print(" ");
        System.out.print(right);

    }
}
