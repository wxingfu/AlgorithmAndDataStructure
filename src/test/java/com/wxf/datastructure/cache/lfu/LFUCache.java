package com.wxf.datastructure.cache.lfu;

import java.util.HashMap;
import java.util.LinkedHashSet;

public class LFUCache {

    private final int capacity;

    private int minFreq;

    private final HashMap<Integer, Integer> keyToVal;

    private final HashMap<Integer, Integer> keyToFreq;

    private final HashMap<Integer, LinkedHashSet<Integer>> freqToKeys;

    public LFUCache(int capacity) {
        keyToVal = new HashMap<>();
        keyToFreq = new HashMap<>();
        freqToKeys = new HashMap<>();
        this.capacity = capacity;
        this.minFreq = 0;
    }

    public int get(int key) {
        if (!keyToVal.containsKey(key)) {
            return -1;
        }
        increaseFreq(key);
        return keyToVal.get(key);
    }

    private void increaseFreq(int key) {
        int freq = keyToFreq.get(key);
        keyToFreq.put(key, freq + 1);
        freqToKeys.get(freq).remove(key);
        freqToKeys.putIfAbsent(freq + 1, new LinkedHashSet<>());
        freqToKeys.get(freq + 1).add(key);
        if (freqToKeys.get(freq).isEmpty()) {
            freqToKeys.remove(freq);
            if (freq == minFreq) {
                minFreq++;
            }
        }
    }

    public void put(int key, int value) {
        if (capacity <= 0) {
            return;
        }
        if (keyToVal.containsKey(key)) {
            keyToVal.put(key, value);
            increaseFreq(key);
            return;
        }
        if (capacity <= keyToVal.size()) {
            removeMinFreqKey();
        }
        keyToVal.put(key, value);
        keyToFreq.put(key, 1);
        freqToKeys.putIfAbsent(1, new LinkedHashSet<>());
        freqToKeys.get(1).add(key);
        minFreq = 1;
    }

    private void removeMinFreqKey() {
        LinkedHashSet<Integer> keyList = freqToKeys.get(minFreq);
        int deleteKey = keyList.iterator().next();
        keyList.remove(deleteKey);
        if (keyList.isEmpty()) {
            freqToKeys.remove(minFreq);
        }
        keyToVal.remove(deleteKey);
        keyToFreq.remove(deleteKey);
    }
}
