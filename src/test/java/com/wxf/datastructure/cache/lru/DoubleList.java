package com.wxf.datastructure.cache.lru;

public class DoubleList {

    private final DLinkedNode head;

    private final DLinkedNode tail;

    private int size;

    public DoubleList() {
        head = new DLinkedNode(0, 0);
        tail = new DLinkedNode(0, 0);

        head.next = tail;
        tail.prev = head;

        size = 0;
    }

    public void addLast(DLinkedNode x) {
        x.prev = tail.prev;
        x.next = head;
        tail.prev.next = x;
        tail.prev = x;

        size++;
    }

    public void remove(DLinkedNode x) {
        x.prev.next = x.next;
        x.next.prev = x.prev;
        size--;
    }

    public DLinkedNode removeFirst() {
        if (head.next == tail) {
            return null;
        }

        DLinkedNode first = head.next;
        remove(first);

        return first;
    }

    public int size() {
        return size;
    }
}
