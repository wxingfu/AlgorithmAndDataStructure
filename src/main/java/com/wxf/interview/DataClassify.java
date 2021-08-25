package com.wxf.interview;

import java.util.Scanner;
import java.util.TreeSet;

/**
 * 输入描述:
 * 一组输入整数序列I和一组规则整数序列R，I和R序列的第一个整数为序列的个数（个数不包含第一个整数）；整数范围为0~0xFFFFFFFF，序列个数不限
 * <p>
 * 输出描述:
 * 从R依次中取出R<i>，对I进行处理，找到满足条件的I：
 * I整数对应的数字需要连续包含R<i>对应的数字。比如R<i>为23，I为231，那么I包含了R<i>，条件满足 。
 * 按R<i>从小到大的顺序:
 * (1)先输出R<i>；
 * (2)再输出满足条件的I的个数；
 * (3)然后输出满足条件的I在I序列中的位置索引(从0开始)；
 * (4)最后再输出I。
 * 附加条件：
 * (1)R<i>需要从小到大排序。相同的R<i>只需要输出索引小的以及满足条件的I，索引大的需要过滤掉
 * (2)如果没有满足条件的I，对应的R<i>不用输出
 * (3)最后需要在输出序列的第一个整数位置记录后续整数序列的个数(不包含“个数”本身)
 * <p>
 * 序列I：15,123,456,786,453,46,7,5,3,665,453456,745,456,786,453,123（第一个15表明后续有15个整数）
 * 序列R：5,6,3,6,3,0（第一个5表明后续有5个整数）
 * 输出：30, 3,6,0,123,3,453,7,3,9,453456,13,453,14,123,6,7,1,456,2,786,4,46,8,665,9,453456,11,456,12,786
 * 说明：
 * 30----后续有30个整数
 * 3----从小到大排序，第一个R<i>为0，但没有满足条件的I，不输出0，而下一个R<i>是3
 * 6--- 存在6个包含3的I
 * 0--- 123所在的原序号为0
 * 123--- 123包含3，满足条件
 * <p>
 * <p>
 * 输入
 * 15 123 456 786 453 46 7 5 3 665 453456 745 456 786 453 123
 * 5 6 3 6 3 0
 * 输出
 * 30 3 6 0 123 3 453 7 3 9 453456 13 453 14 123 6 7 1 456 2 786 4 46 8 665 9 453456 11 456 12 786
 */
public class DataClassify {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            // 输入数据
            int numI = in.nextInt();
            int[] I = new int[numI];
            for (int i = 0; i < numI; i++) {
                I[i] = in.nextInt();
            }
            in.nextLine();
            int numR = in.nextInt();
            int[] R = new int[numR];
            for (int i = 0; i < numR; i++) {
                R[i] = in.nextInt();
            }
            // 排序和去重
            TreeSet<Integer> treeR = new TreeSet<>();
            for (int i = 0; i < numR; i++) {
                treeR.add(R[i]);
            }
            // 存储最终数据：个数 + 序列
            StringBuilder s = new StringBuilder();
            // 统计结果个数
            int[] number = new int[treeR.size()];
            // 转成integer数组
            Integer[] rArray = treeR.toArray(new Integer[]{});
            // R<i>碰撞I<j>
            for (int i = 0; i < rArray.length; i++) {
                int n = rArray[i];
                // 存储符合条件的I<j>
                StringBuilder result = new StringBuilder();
                for (int j = 0; j < numI; j++) {
                    if (!((String.valueOf(I[j])).indexOf(String.valueOf(n)) == -1)) {
                        number[i]++;
                        result.append(j).append(" ");
                        result.append(I[j]).append(" ");
                    }
                }
                if (number[i] != 0) {
                    s.append(n).append(" ").append(number[i]).append(" ").append(result);
                }
            }
            String[] str = s.toString().split(" ");
            s.insert(0, str.length + " ");
            System.out.println(s);
        }
    }
}
