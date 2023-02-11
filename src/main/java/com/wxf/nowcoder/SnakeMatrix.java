package com.wxf.nowcoder;

import java.util.Scanner;

public class SnakeMatrix {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int num = in.nextInt();
            int y = 1;//列的方向第一个肯定是1
            int yCount = 1;//列由上往下是等差数列，第一行和第二行差1
            for (int i = 1; i <= num; i++) {//行的循环次数
                int x = y;//第i行的第一个数就是列的第i个数
                int xCount = i + 1; //可以看到第i行第一个加数刚好是i+1
                for (int j = 1; j <= num - i + 1; j++) { //列的循环次数，每次少一列
                    System.out.print(x + " ");//循环输出x
                    x =x+ xCount;    //等差数列每次+1
                    xCount++;
                }
                System.out.println("");//换行
                y =y+ yCount; //等差数列每次加1
                yCount++;
            }
        }
    }
}
