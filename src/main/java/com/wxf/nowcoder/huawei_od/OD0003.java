package com.wxf.nowcoder.huawei_od;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

/**
 * 最大化控制资源成本
 *
 * <a href="https://blog.csdn.net/choukai0932/article/details/128226515">...</a>
 */
public class OD0003 {

    public static int max_machine;

    public static void main(String[] args) {
        // 处理输入
        Scanner in = new Scanner(System.in);
        int taskNum = in.nextInt();

        // 构造输入数据结构
        ArrayList<ArrayList<Integer>> outerArrayList = new ArrayList<ArrayList<Integer>>();

        for (int i = 0; i < taskNum; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            int c = in.nextInt();
            ArrayList<Integer> innerArraylist = new ArrayList<Integer>();
            innerArraylist.add(a);
            innerArraylist.add(b);
            innerArraylist.add(c);
            outerArrayList.add(innerArraylist);
            // 避免完全没有交集的特殊情况
            if (max_machine < c) {
                max_machine = c;
            }
        }

        // 递归求交集
        while (outerArrayList.size() > 1) {
            outerArrayList = cal_public_range(outerArrayList);
        }
        System.out.println(max_machine);
    }

    public static ArrayList<ArrayList<Integer>> cal_public_range(ArrayList<ArrayList<Integer>> ranges) {
        // 先排序
        Comparator<ArrayList<Integer>> myComparator = new Comparator<ArrayList<Integer>>() {
            @Override
            public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
                if (!o1.get(0).equals(o2.get(0))) {
                    return o1.get(0) - o2.get(0);
                } else {
                    return o1.get(1) - o2.get(2);
                }
            }
        };
        ranges.sort(myComparator);

        // 求交集
        ArrayList<ArrayList<Integer>> public_range = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < ranges.size(); i++) {
            for (int j = i + 1; j < ranges.size(); j++) {
                int left = Math.max(ranges.get(i).get(0), ranges.get(j).get(0));
                int right = Math.min(ranges.get(i).get(1), ranges.get(j).get(1));
                if (left <= right) {
                    ArrayList<Integer> temp = new ArrayList<Integer>();
                    temp.add(left);
                    temp.add(right);
                    temp.add(ranges.get(i).get(2) + ranges.get(j).get(2));
                    public_range.add(temp);
                    if (ranges.get(i).get(2) + ranges.get(j).get(2) > max_machine) {
                        max_machine = ranges.get(i).get(2) + ranges.get(j).get(2);
                    }
                }
            }
        }
        return public_range;
    }

}
