package com.wxf.datastructure.cache.lru;

import java.util.LinkedHashMap;
import java.util.Map;

class LRUCache3 extends LinkedHashMap<Integer, Integer> {
    private final int capacity;

    public LRUCache3(int capacity) {
        super(capacity, 0.75F, true);
        this.capacity = capacity;
    }

    public int get(int key) {
        return super.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        super.put(key, value);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size() > capacity;
    }

}