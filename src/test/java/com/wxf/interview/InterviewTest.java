package com.wxf.interview;


import org.junit.Test;

public class InterviewTest {

    @Test
    public void test1() {
        // String s = "batkqdhjnrwtsmzidswdnenqpsblsszldyttytrgenaizwehntqiaaufble";
        // String s = "guwldvzrsfurobidegiyazkggfpgmyhlrbfjrjerrbnjdenrdxjfmrhtumfdsedkcmthphgavzxlmpcpwbkwsvplhmkbkgkw";
        // String s = "qwgskielmifulepgddovwodcptnletyryzexjqizlnetbihjljprciobxzahayfbyvncplkffyrhluetzccuthbrdztvvkcifqar";
        // System.out.println(s.length());
        // System.out.println(s.length() / 8);
        // System.out.println(s.length() % 8);
        // System.out.println(s.substring(0, 8));

        // int m = 3;
        // int n = 2;
        // int[][] f = new int[m][n];
        // for (int i = 0; i < m; i++) {
        //     for (int j = 0; j < n; j++) {
        //         System.out.println(f[i][j]);
        //     }
        // }


        Integer[] nums = new Integer[10];
        System.out.println(nums);

    }

    @Test
    public void test2() {

        int[][] yangHui = new int[10][];
        for (int i = 0; i < yangHui.length; i++) {
            yangHui[i] = new int[i + 1];
            yangHui[i][0] = 1;
            yangHui[i][i] = 1;

            if (i > 1) {
                for (int j = 1; j < yangHui[i].length - 1; j++) {
                    yangHui[i][j] = yangHui[i - 1][j - 1] + yangHui[i - 1][j];
                }
            }
        }

        for (int[] ints : yangHui) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }
}
