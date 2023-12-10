package com.wxf.nowcoder;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DecAndHexOctal {

    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("A", 10);
        map.put("B", 11);
        map.put("C", 12);
        map.put("D", 13);
        map.put("E", 14);
        map.put("F", 15);
        Scanner in = new Scanner(System.in);
        String a = in.nextLine();
        a = a.substring(2);
        int b = a.length();
        double res = 0.0;
        int i = 0;
        while (b > 0) {
            String d = a.charAt(i) + "";
            if (map.containsKey(d)) {
                res = res + map.get(d) * Math.pow(16, (double) b - 1);
            } else {
                res = res + Integer.parseInt(d) * Math.pow(16, (double) b - 1);
            }
            i++;
            b--;
        }
        System.out.println((int) res);

        Map<Integer, String> map2 = new HashMap<>();
        map2.put(10, "A");
        map2.put(11, "B");
        map2.put(12, "C");
        map2.put(13, "D");
        map2.put(14, "E");
        map2.put(15, "F");
        int rr = (int) res;
        int aa = 0;
        int bb = 0;
        StringBuilder result = new StringBuilder();
        while (rr % 16 > 0) {
            aa = rr / 16;
            bb = rr % 16;
            if (map2.containsKey(bb)) {
                result.append(map2.get(bb));
            } else {
                result.append(bb);
            }
            rr = aa;
        }
        System.out.println("0x" + result);
    }
}
