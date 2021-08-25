package com.wxf.algorithm.search;

/**
 * @author wxf
 * @date 2020-10-30
 * @description
 */
public class BlockSearch {

    public static void main(String[] args) {
        int[] index = {22, 48, 86};
        int[] st2 = {22, 12, 13, 8, 9, 20, 33, 42, 44, 38, 24, 48, 60, 58, 74, 49, 86, 53};
        for (int i = 0; i < 100; i++) {
            System.out.println(blockSearch(index, st2, i, 6));
        }
    }

    /**
     * 分块查找是折半查找和顺序查找的一种改进方法，分块查找由于只要求索引表是有序的，
     * 对块内节点没有排序要求，因此特别适合于节点动态变化的情况。
     * 分块查找要求把一个数据分为若干块，每一块里面的元素可以是无序的，但是块与块之间的元素需要是有序的。
     * 即第1块中任一元素的关键字都必须小于第2块中任一元素的关键字；
     * 而第2块中任一元素又都必须小于第3块中的任一元素，……。
     *
     * @param index 每个元素代表的是每块的最大值
     * @param array 代表的是要查找的数组
     * @param key   代表要查找的元素
     * @param m     代表每个块大小
     * @return
     */
    public static int blockSearch(int[] index, int[] array, int key, int m) {
        int i = search(index, key);
        if (i < 0)
            return -1;
        for (int j = m * i, length = j + m; j < length; j++) {
            if (array[j] == key)
                return j;
        }
        return -1;
    }

    private static int search(int[] index, int key) {
        int start = 0;
        int end = index.length - 1;
        if (key > index[end])
            return -1;
        while (start <= end) {
            int mid = start + ((end - start) >> 1);
            if (index[mid] >= key) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }
}
