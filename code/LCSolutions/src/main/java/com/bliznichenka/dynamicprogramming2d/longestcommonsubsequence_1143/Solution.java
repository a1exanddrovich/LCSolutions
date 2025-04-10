package com.bliznichenka.dynamicprogramming2d.longestcommonsubsequence_1143;

public class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int[] prevDp = new int[text1.length() + 1];

        for (int i = text2.length() - 1; i >= 0; i--) {
            int[] curDp = new int[text1.length() + 1];
            for (int j = text1.length() - 1; j >= 0; j--) {
                if (text1.charAt(j) == text2.charAt(i)) {
                    curDp[j] = 1 + prevDp[j + 1];
                } else {
                    curDp[j] = Math.max(prevDp[j], curDp[j + 1]);
                }
            }
            prevDp = curDp;
        }

        return prevDp[0];
    }
}
