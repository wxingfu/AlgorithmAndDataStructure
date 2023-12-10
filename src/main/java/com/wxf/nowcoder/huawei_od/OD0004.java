package com.wxf.nowcoder.huawei_od;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/**
 * 区间连接器
 * <a href="https://blog.csdn.net/choukai0932/article/details/128539649">...</a>
 */
public class OD0004 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String[] regionsStr = sc.nextLine().replaceAll("\\[", "")
                .replaceAll("]", "")
                .split(",");
        String[] linksStr = sc.nextLine().replaceAll("\\[", "")
                .replaceAll("]", "")
                .split(",");

        List<int[]> regions = new ArrayList<>();    // 区间集合
        for (int i = 0; i < regionsStr.length; i += 2) {
            int left = Integer.parseInt(regionsStr[i]);
            int right = Integer.parseInt(regionsStr[i + 1]);
            regions.add(new int[]{left, right});
        }

        List<Integer> links = new ArrayList<>();    // 连接器集合
        for (String s : linksStr) {
            links.add(Integer.valueOf(s));
        }

        regions.sort((a, b) -> {    // 区间进行升序排序
            if (b[0] == a[0]) {
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });

        int[] region = null;
        Iterator<int[]> iter = regions.iterator();
        while (iter.hasNext()) {
            int[] next = iter.next();
            if (region == null) {
                region = next;
            } else if (region[1] >= next[0]) {
                if (region[1] < next[1]) {
                    region[1] = next[1];
                }
                iter.remove();
            } else {
                region = next;
            }
        }

        List<Integer> gaps = new ArrayList<>();     // 各区间所需连接器的长度集合
        iter = regions.iterator();
        region = null;
        while (iter.hasNext()) {
            int[] next = iter.next();
            if (region != null) {
                int gap = next[0] - region[1];
                gaps.add(gap);
            }
            region = next;
        }

        Collections.sort(gaps);
        Collections.sort(links);

        int i = 0; // gaps index
        int j = 0; // links index
        while (i < gaps.size() && j < links.size()) {
            if (links.get(j) >= gaps.get(i)) {   // 连接器长度大于等于所需连接器长度，符合要求
                gaps.set(i, 0);     // 可以连接的两个区间距离设置为0
                i++;
            }
            j++;    // 使用过的连接器不再使用
        }

        int noneZoreNum = 0;
        for (int g : gaps) {
            if (g > 0) {     // 大于0，说明两个区间无法进行连接
                noneZoreNum++;
            }
        }

        System.out.println(noneZoreNum + 1);
    }

}
