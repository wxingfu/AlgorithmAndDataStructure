package com.wxf.leetcode.sword_finger_offer;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，
 * 调用 min、push 及 pop 的时间复杂度都是 O(1)。
 * <p>
 * 用一个辅助栈来存储和操作非严格递增数据
 */
public class MinStack {

    Deque<Integer> st1;
    Deque<Integer> st2;

    public MinStack() {
        st1 = new LinkedList<>();
        st2 = new LinkedList<>();
    }

    public void push(int x) {
        st1.push(x);
        if (st2.isEmpty() || st2.peek() >= x) {
            st2.push(x);
        }
    }

    public void pop() {
        if (!st1.isEmpty() && !st2.isEmpty()) {
            if (st1.pop().equals(st2.peek())) {
                st2.pop();
            }
        }
    }

    public int top() {
        if (st1.isEmpty()) {
            return -1;
        }
        return st1.peek();
    }

    public int min() {
        if (st2.isEmpty()) {
            return -1;
        }
        return st2.peek();
    }
}
