package com.wxf;

import java.util.HashMap;
import java.util.Map;

public class MyTest {

    public static void main(String[] args) {
        /*int a = 0;
        System.out.println(a);*/

        /*byte b = 12;
        int b1 = b + 1;
        System.out.println(b1);*/

        /*CQueue obj = new CQueue();
        int param_1 = obj.deleteHead();
        System.out.println(param_1);
        obj.appendTail(5);
        obj.appendTail(2);
        int param_2 = obj.deleteHead();
        System.out.println(param_2);
        int param_3 = obj.deleteHead();
        System.out.println(param_3);*/

        // System.out.println(1 <= 2);

        /*MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.min());
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.min());*/

        Map<Character, Integer> frequency = new HashMap<Character, Integer>();
        Integer integer = frequency.get('a');
        System.out.println(integer);
    }
}
