package com.wxf.leetcode.sword_finger_offer;

import com.wxf.common.ListNode;

/**
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 * <p>
 * 示例 1：
 * 输入：head = [1,3,2]
 * 输出：[2,3,1]
 * <p>
 * 链接：https://leetcode-cn.com/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof/
 */
public class ReversePrintList {
    public static void main(String[] args) {
        ListNode head = new ListNode();
        head.next = new ListNode(1);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        int[] ints = reversePrint(head);
        for (int anInt : ints) {
            System.out.print(anInt + " ");
        }
    }

    public static int[] reversePrint(ListNode head) {
        ListNode node = head;
        int length = 0;
        while (node != null) {
            length++;
            node = node.next;
        }

        int[] arr = new int[length];

        int i = length - 1;
        while (head != null) {
            arr[i] = head.value;
            head = head.next;
            i--;
        }
        return arr;
    }
}
