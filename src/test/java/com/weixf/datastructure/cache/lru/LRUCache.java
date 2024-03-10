package com.weixf.datastructure.cache.lru;

import java.util.HashMap;

public class LRUCache {

    private final HashMap<Integer, DLinkedNode> map;

    private final DoubleList cache;

    private final int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        cache = new DoubleList();
    }


    private void makeRecently(int key) {
        DLinkedNode x = map.get(key);
        cache.remove(x);
        cache.addLast(x);
    }


    private void addRecently(int key, int val) {
        DLinkedNode x = new DLinkedNode(key, val);
        cache.addLast(x);
        map.put(key, x);
    }

    private void deleteKey(int key) {
        DLinkedNode x = map.get(key);
        cache.remove(x);
        map.remove(key);
    }

    private void removeLastRecently() {
        DLinkedNode deleteDLinkedNode = cache.removeFirst();
        map.remove(deleteDLinkedNode.key);
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        makeRecently(key);
        return map.get(key).val;
    }

    public void put(int key, int val) {
        if (map.containsKey(key)) {
            deleteKey(key);
            addRecently(key, val);
            return;
        }
        if (capacity == cache.size()) {
            removeLastRecently();
        }
        addRecently(key, val);
    }

}
