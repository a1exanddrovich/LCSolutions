package com.bliznichenka.dynamicprogramming2d.onesandzeroes_474;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();

        String[] strs = {"10","0001","111001","1","0"};
        int m = 5;
        int n = 3;
        System.out.println(s.findMaxForm(strs, m, n));
    }
}
