package com.wxf.leetcode.sword_finger_offer;

import java.util.Stack;

/**
 * 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，
 * 分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead操作返回 -1 )
 * <p>
 * 链接：https://leetcode-cn.com/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof
 */
public class CQueue {

    Stack<Integer> st1;
    Stack<Integer> st2;

    public CQueue() {
        st1 = new Stack<>();
        st2 = new Stack<>();
    }

    public void appendTail(int value) {
        st1.push(value);
    }

    public int deleteHead() {
        if (st2.isEmpty()) {
            while (!st1.isEmpty()) {
                st2.push(st1.pop());
            }
        }
        if (st2.isEmpty()) {
            return -1;
        } else {
            return st2.pop();
        }
    }
}
