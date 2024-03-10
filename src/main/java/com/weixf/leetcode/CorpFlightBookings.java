package com.weixf.leetcode;

/**
 * 这里有n个航班，它们分别从 1 到 n 进行编号。
 * <p>
 * 有一份航班预订表bookings ，
 * 表中第i条预订记录bookings[i] = [firsti, lasti, seatsi]
 * 意味着在从 firsti到 lasti（包含 firsti和lasti）的每个航班上预订了seatsi个座位。
 * <p>
 * 请你返回一个长度为n的数组answer，其中answer[i]是航班i上预订的座位总数。
 * <p>
 * 1 <= n <= 2 * 104
 * 1 <= bookings.length <= 2 * 104
 * bookings[i].length == 3
 * 1 <= firsti <= lasti <= n
 * 1 <= seatsi <= 104
 * <p>
 * 链接：https://leetcode-cn.com/problems/corporate-flight-bookings
 */
public class CorpFlightBookings {
    public static void main(String[] args) {
        // bookings = [[1,2,10],[2,3,20],[2,5,25]], n = 5
        int[][] bookings = {{1, 2, 10}, {2, 3, 20}, {2, 5, 25}};
        int[] book = corpFlightBookings(bookings, 5);
        for (int i = 0; i < book.length; i++) {
            System.out.print(book[i] + " ");
        }
    }

    /**
     * 差分数组本质上也是一个数组，我们暂且定义差分数组为d，
     * 差分数组d的大小和原来arr数组大小一样，
     * 而且d[i]=arr[i]-arr[i-1](i≠0)，且d[i]=0，
     * 含义是原来数组i位置上的元素和i-1位置上的元素作差，
     * 得到的值就是d[i]的值。
     *
     * @param bookings
     * @param n
     * @return
     */
    public static int[] corpFlightBookings(int[][] bookings, int n) {
        int[] answer = new int[n];
        int row = bookings.length;
        for (int i = 0; i < row; i++) {
            for (int j = bookings[i][0]; j <= bookings[i][1]; j++) {
                answer[j - 1] += bookings[i][2];
            }
        }
        return answer;
    }

    /**
     * 官解
     * <p>
     * 差分数组解法
     * <p>
     * 差分数组对应的概念是前缀和数组，
     * 对于数组 [1,2,2,4][1,2,2,4]，
     * 其差分数组为 [1,1,0,2][1,1,0,2]，
     * 差分数组的第 ii 个数即为原数组的第 i-1i−1 个元素和第 ii 个元素的差值，
     * 也就是说我们对差分数组求前缀和即可得到原数组。
     * <p>
     * 差分数组的性质是，当我们希望对原数组的某一个区间 [l,r][l,r] 施加一个增量inc 时，
     * 差分数组 dd 对应的改变是：d[l]d[l]增加inc，d[r+1]d[r+1] 减少inc
     * <p>
     * 链接：https://leetcode-cn.com/problems/corporate-flight-bookings/solution/hang-ban-yu-ding-tong-ji-by-leetcode-sol-5pv8/
     *
     * @param bookings
     * @param n
     * @return
     */
    public static int[] corpFlightBookings2(int[][] bookings, int n) {
        int[] nums = new int[n];
        for (int[] booking : bookings) {
            nums[booking[0] - 1] += booking[2];
            if (booking[1] < n) {
                nums[booking[1]] -= booking[2];
            }
        }
        for (int i = 1; i < n; i++) {
            nums[i] += nums[i - 1];
        }
        return nums;
    }
}
