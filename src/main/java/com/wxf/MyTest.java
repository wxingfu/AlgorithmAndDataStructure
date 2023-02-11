package com.wxf;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class MyTest {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String str = in.nextLine();
            int len = str.length();
            Map<String, Integer> map = new LinkedHashMap<>();
            map.put("a", 0);
            map.put("b", 0);
            map.put("c", 0);
            map.put("d", 0);
            for (int i = 0; i < len; i++) {
                char ch = str.charAt(i);
                if ((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z')) {
                    map.put("a", map.get("a") + 1);
                } else if (ch == ' ') {
                    map.put("b", map.get("b") + 1);
                } else if (ch >= '0' && ch <= '9') {
                    map.put("c", map.get("c") + 1);
                } else {
                    map.put("d", map.get("d") + 1);
                }
            }

            for (String k : map.keySet()) {
                System.out.println(map.get(k));
            }
        }
    }
}
