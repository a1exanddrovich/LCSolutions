package com.bliznichenka.dynamicprogramming2d.longestpalindromicsubsequence_516;

public class Solution {
    public int longestPalindromeSubseq(String s) {
        return longestCommonSubsequence(s, new StringBuilder(s).reverse().toString());
    }

    private int longestCommonSubsequence(String text1, String text2) {
        int[] prevDp = new int[text2.length() + 1];

        for (int i = 0; i < text1.length(); i++) {
            int[] curDp = new int[text2.length() + 1];
            for (int j = 0; j < text2.length(); j++) {
                if (text1.charAt(i) == text2.charAt(j)) {
                    curDp[j + 1] = 1 + prevDp[j + 1 - 1];
                } else {
                    curDp[j + 1] = Math.max(
                            prevDp[j + 1],
                            curDp[j + 1 - 1]
                    );
                }
            }
            prevDp = curDp;
        }

        return prevDp[text2.length()];
    }
}
