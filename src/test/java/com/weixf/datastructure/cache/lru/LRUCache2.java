package com.weixf.datastructure.cache.lru;

import java.util.LinkedHashMap;

public class LRUCache2 {

    private final LinkedHashMap<Integer, Integer> cache = new LinkedHashMap<>();

    private final int capacity;

    public LRUCache2(int capacity) {
        this.capacity = capacity;
    }


    private void makeRecently(int key) {
        int value = cache.get(key);
        cache.remove(key);
        cache.put(key, value);
    }

    public int get(int key) {
        if (!cache.containsKey(key)) {
            return -1;
        }
        makeRecently(key);
        return cache.get(key);
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            cache.put(key, value);
            makeRecently(key);
            return;
        }
        if (cache.size() >= capacity) {
            int oldKey = cache.keySet().iterator().next();
            cache.remove(oldKey);
        }
        cache.put(key, value);
    }

}
