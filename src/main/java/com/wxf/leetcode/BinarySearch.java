package com.wxf.leetcode;

/**
 * 二分查找
 */
public class BinarySearch {

    public static void main(String[] args) {
        int[] nums = new int[]{5};
        int index = search(nums, 5);
        System.out.println(index);
    }

    public static int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        int mid = 0;
        while (low <= high) {
            mid = (low + high) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] > target) {
                high = mid - 1;
            }
            if (nums[mid] < target) {
                low = mid + 1;
            }
        }
        return -1;
    }
}
