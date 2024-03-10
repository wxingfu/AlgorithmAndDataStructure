package com.weixf.leetcode.sword_finger_offer;

/**
 * 一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。
 * 在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。
 * <p>
 *  
 * <p>
 * 示例 1:
 * 输入: [0,1,3]
 * 输出: 2
 * <p>
 * 示例2:
 * 输入: [0,1,2,3,4,5,6,7,9]
 * 输出: 8
 * <p>
 * 链接：https://leetcode-cn.com/problems/que-shi-de-shu-zi-lcof
 */
public class MissingNumber {

    public static void main(String[] args) {
        int[] nums = new int[]{0};
        int number = missingNumber(nums);
        System.out.println(number);
    }

    public static int missingNumber(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            if (i < nums[i]) {
                return i;
            }
            i++;
        }
        return i;
    }
}
