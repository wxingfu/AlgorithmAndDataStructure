package com.wxf.nowcoder.huawei_od;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * 羊、狼、农夫过河
 * <a href="https://blog.csdn.net/choukai0932/article/details/128227517">...</a>
 */
public class OD0001 {

    public static int min_times;

    public static void main(String[] args) {
        // 处理输入
        Scanner in = new Scanner(System.in);
        // 转为数组
        List<Integer> nums = Arrays.stream(in.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        int M = nums.get(0);
        int N = nums.get(1);
        int X = nums.get(2);

        min_times = (M + N) * X;

        // 表示已运输到对岸的羊、狼个数
        int m_temp = 0;
        int n_temp = 0;

        transport(M, N, X, m_temp, n_temp, 0);

        if (min_times == (M + N) * X) {
            System.out.println(0);
        } else {
            System.out.println(min_times);
        }

    }

    // m0, n0 分别表示剩余的羊、狼个数， x为船容量
    // m1, n1 分别表示运输到对岸的羊、狼个数，times为次数
    public static int transport(int m0, int n0, int x, int m1, int n1, int times) {
        // 若可以一次性运走，结束了，注意等于号。。。
        if (x >= m0 + n0) {
            if (times + 1 < min_times) {
                min_times = times + 1;
            }
            return times + 1;
        }
        // 尝试运一部分狼一部分羊
        // 要上船的羊数量不可以超过岸上数量、也不可以超过船的容量
        for (int i = 0; i <= m0 && i <= x; i++) {
            // 要上船的狼的数量不可以超过岸上数量、也不可以超过船装了羊后的剩余的容量
            for (int j = 0; j <= n0 && i + j <= x; j++) {
                // 不可以不运
                if (i + j == 0) {
                    continue;
                }
                // 船离岸后，原来这岸，要么没有羊，要么羊比狼多，才可以运；对岸也要检查，不考虑回程带动物
                if ((m0 - i == 0 || m0 - i > n0 - j) && (m1 + i == 0 || m1 + i > n1 + j)) {
                    // 运一次
                    int result = transport(m0 - i, n0 - j, x, m1 + i, n1 + j, times + 1);
                    // 如果获取了结果，和minTime比较，但是不结束，继续检查
                    if (result < min_times && result != 0) {
                        min_times = result;
                    }
                }
            }
        }
        // 没有方案了。。返回0
        return 0;
    }

}
