package com.weixf.leetcode.sword_finger_offer;

/**
 * 在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个高效的函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * <p>
 * 示例:
 * 现有矩阵 matrix 如下：
 * [
 * [1,   4,  7, 11, 15],
 * [2,   5,  8, 12, 19],
 * [3,   6,  9, 16, 22],
 * [10, 13, 14, 17, 24],
 * [18, 21, 23, 26, 30]
 * ]
 * 给定 target=5，返回true。
 * 给定target=20，返回false。
 * <p>
 * 链接：https://leetcode-cn.com/problems/er-wei-shu-zu-zhong-de-cha-zhao-lcof
 */
public class FindNumberIn2DArray {

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
        boolean number = findNumberIn2DArray(matrix, 20);
        System.out.println(number);
    }

    /**
     * 若数组为空，返回 false
     * <p>
     * 初始化行下标为 0，列下标为二维数组的列数减 1
     * <p>
     * 重复下列步骤，直到行下标或列下标超出边界
     * *获得当前下标位置的元素 num
     * *如果 num 和 target 相等，返回 true
     * *如果 target 大于 num，行下标加 1
     * *如果 target 小于 num，列下标减 1
     * <p>
     * 循环体执行完毕仍未找到元素等于 target ，说明不存在这样的元素，返回 false
     * <p>
     *
     * @param matrix
     * @param target
     * @return
     */
    public static boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int n = matrix.length;
        int m = matrix[0].length;
        int row = 0, column = m - 1;
        while (row < n && column >= 0) {
            int num = matrix[row][column];
            if (target == num) {
                return true;
            } else if (target < num) {
                column--;
            } else {
                row++;
            }
        }
        return false;
    }
}
