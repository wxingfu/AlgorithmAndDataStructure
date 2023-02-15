package com.wxf;

public class MyTest {

    public static void main(String[] args) {


        int i =5;
        int j = 10;
        System.out.println(i);
        System.out.println(~i);
        System.out.println(Integer.toBinaryString(i));
        System.out.println(Integer.toBinaryString(~i));
        System.out.println(Integer.toBinaryString(j));
        System.out.println(Integer.toBinaryString(~j));
        System.out.println(~j);
        System.out.println(i + ~j);
    }
}
