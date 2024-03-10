package com.weixf.algorithm.search;

import java.util.Arrays;

/*
  斐波那契数列我们都知道{0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55 }，
  前后的比值会越来越接近0.618，也就是黄金分割点。
  0.618也被公认为最具有审美意义的比例数字。
  斐波那契查找原理其实和二分法查找原理差不多，只不过计算中间值mid的方式不同，
  还有一点就是斐波那契查找的数组长度必须是f（k）-1，这样我们就可以把斐波那契数列进行划分
  f(k)-1=f(k-1)+f(k-2)-1=[f(k-1)-1]+1+[f(k-2)-1]；
  然后前面部分和后面部分都还可以继续进行划分。
  但实际上我们要查找的数组长度不可能都是f（k）-1，
  所以我们要补齐最后的部分，让数组的长度等于f（k）-1，
  让数组的最后一位数字把后面铺满。比如我们查找的数组长度是21，
  而f（8）-1=21-1=20；小于21，所以f（8）-1是不行的，
  我们需要把数组长度变为f（9）-1=34-1=33，后面多余的我们都用原数组最后的那个值填充。
 */

/**
 * @author wxf
 * @date 2020-10-29
 * @description
 */
public class FibonacciSearch {

    public static int maxSize = 20;

    public static void main(String[] args) {
        int[] arr = {1, 8, 10, 89, 1000, 1234};
        // System.out.println("index=" + fibSearch(arr, 1));
        System.out.println("index=" + fibonacciSearch(arr, 1));
    }

    public static int fibSearch(int[] arr, int key) {
        int low = 0;
        int high = arr.length - 1;
        int k = 0; // 表示斐波那契分割数值的下标
        int mid = 0; // 存放mid值
        int[] f = fib(); // 获取到斐波那契数列
        // 获取到斐波那契分割数值的下标
        while (high > f[k] - 1) {
            k++;
        }
        // 因为 f[k] 值 可能大于 a 的 长度，
        // 因此我们需要使用Arrays类，构造一个新的数组，并指向temp[]
        // 不足的部分会使用0填充
        int[] temp = Arrays.copyOf(arr, f[k]);
        // 实际上需求使用arr数组最后的数填充 temp
        // 举例: temp = {1,8, 10, 89, 1000, 1234, 0, 0}  => {1,8, 10, 89, 1000, 1234, 1234, 1234,}
        for (int i = high + 1; i < temp.length; i++) {
            temp[i] = arr[high];
        }
        // 使用while来循环处理，找到我们的数 key
        while (low <= high) { // 只要这个条件满足，就可以找
            mid = low + f[k - 1] - 1;
            if (key < temp[mid]) { // 向数组的前面查找(左边)
                high = mid - 1;
                // 1. 全部元素 = 前面的元素 + 后边元素
                // 2. f[k] = f[k-1] + f[k-2]
                // 因为 前面有 f[k-1]个元素,所以可以继续拆分 f[k-1] = f[k-2] + f[k-3]
                // 即 在 f[k-1] 的前面继续查找 k--, 即下次循环 mid = f[k-1-1]-1
                k--;
            } else if (key > temp[mid]) { // 向数组的后面查找(右边)
                low = mid + 1;
                // 1. 全部元素 = 前面的元素 + 后边元素
                // 2. f[k] = f[k-1] + f[k-2]
                // 3. 因为后面我们有f[k-2] 所以可以继续拆分 f[k-1] = f[k-3] + f[k-4]
                // 4. 即在f[k-2] 的前面进行查找 k -=2
                // 5. 即下次循环 mid = f[k - 1 - 2] - 1
                k -= 2;
            } else { // 找到
                // 需要确定，返回的是哪个下标
                if (mid <= high) {
                    return mid;
                } else {
                    return high;
                }
            }
        }
        return -1;
    }

    // 因为后面我们mid=low+F(k-1)-1，需要使用到斐波那契数列，
    // 因此我们需要先获取到一个斐波那契数列
    // 非递归方法得到一个斐波那契数列
    public static int[] fib() {
        int[] f = new int[maxSize];
        f[0] = 1;
        f[1] = 1;
        for (int i = 2; i < maxSize; i++) {
            f[i] = f[i - 1] + f[i - 2];
        }
        return f;
    }

    // -----------------------另外的写法--------------------------------------------------------------

    public static int fibonacciSearch(int[] array, int key) {
        if (array == null || array.length == 0)
            return -1;
        int length = array.length;
        int k = 0;
        while (length > fibonacci(k) - 1 || fibonacci(k) - 1 < 5) {
            k++;
        }
        int[] fb = makeFbArray(fibonacci(k) - 1);
        int low = 0;
        int hight = length - 1;
        while (low <= hight) {
            int middle = low + fb[k - 1] - 1;
            int midvalue;
            if (middle >= length)
                midvalue = array[length - 1];
            else
                midvalue = array[middle];
            if (midvalue > key) {// 要查找的值在前半部分
                hight = middle - 1;
                k = k - 1;
            } else if (midvalue < key) {// 要查找的值在后半部分
                low = middle + 1;
                k = k - 2;
            } else {
                if (middle <= hight) {
                    return middle;
                } else {
                    return hight;
                }
            }
        }
        return -1;
    }

    private static int fibonacci(int n) {
        if (n == 0 || n == 1) return n;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static int[] makeFbArray(int length) {
        int[] array = new int[length];
        array[0] = 0;
        array[1] = 1;
        for (int i = 2; i < length; i++) array[i] = array[i - 1] + array[i - 2];
        return array;
    }
}
