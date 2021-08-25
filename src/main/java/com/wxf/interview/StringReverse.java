package com.wxf.interview;

import java.util.Scanner;

public class StringReverse {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String s = sc.nextLine();
            StringBuilder str = new StringBuilder(s).reverse();
            System.out.println(str.toString());
        }
    }
}
