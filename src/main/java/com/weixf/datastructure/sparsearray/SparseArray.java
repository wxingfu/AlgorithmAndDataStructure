package com.weixf.datastructure.sparsearray;

public class SparseArray {
    public static void main(String[] args) {

        // 创建原始数组
        int[][] OriginChess = new int[11][11];
        OriginChess[1][2] = 1;
        OriginChess[2][3] = 2;
        // 显示原始数组和统计有效数据个数
        int sum = 0;
        for (int[] row : OriginChess) {
            for (int data : row) {
                System.out.printf("%d\t", data);
                if (data != 0) {
                    sum++;
                }
            }
            System.out.println();
        }
        System.out.println("\n有效值个数：" + sum);

        // 创建稀疏数组
        int[][] sparseArr = new int[sum + 1][3];
        sparseArr[0][0] = 11;
        sparseArr[0][1] = 11;
        sparseArr[0][2] = sum;
        // 填入数据
        int count = 0;
        for (int i = 0; i < OriginChess.length; i++) {
            for (int j = 0; j < OriginChess.length; j++) {
                if (OriginChess[i][j] != 0) {
                    count++;
                    sparseArr[count][0] = i;
                    sparseArr[count][1] = j;
                    sparseArr[count][2] = OriginChess[i][j];
                }
            }
        }
        // 显示
        for (int[] arr : sparseArr) {
            System.out.printf("%d\t%d\t%d\t\n", arr[0], arr[1], arr[2]);
        }
        System.out.println();

        // 还原原始数组
        int rows = sparseArr[0][0];
        int cols = sparseArr[0][1];
        int[][] NewChess = new int[rows][cols];
        for (int i = 1; i < sparseArr.length; i++) {
            NewChess[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
        }

        for (int[] newChess : NewChess) {
            for (int chess : newChess) {
                System.out.printf("%d\t", chess);
            }
            System.out.println();
        }
    }
}
