package com.wxf.datastructure.cache.lru;

public class DLinkedNode {

    public int key, val;

    public DLinkedNode next, prev;

    public DLinkedNode() {
    }

    public DLinkedNode(int key, int val) {
        this.key = key;
        this.val = val;
    }
}
