package com.wxf.node;

public class ListNode {

    //  节点值
    public int val;

    //  下一节点的指针
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
        this.next = null;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
