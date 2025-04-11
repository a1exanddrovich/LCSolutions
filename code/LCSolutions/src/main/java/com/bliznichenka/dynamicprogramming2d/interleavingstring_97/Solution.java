package com.bliznichenka.dynamicprogramming2d.interleavingstring_97;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    // Bottom-Up DP
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s3.length() != (s1.length() + s2.length())) {
            return false;
        }

        boolean[][] dp = new boolean[s1.length() + 1][s2.length() + 1];
        dp[s1.length()][s2.length()] = true;

        for (int i = s1.length(); i >= 0; i--) {
            for (int j = s2.length(); j >= 0; j--) {
                int k = i + j;
                if (i < s1.length() && s1.charAt(i) == s3.charAt(k) && dp[i + 1][j]) {
                    dp[i][j] = true;
                }
                if (j < s2.length() && s2.charAt(j) == s3.charAt(k) && dp[i][j + 1]) {
                    dp[i][j] = true;
                }
            }
        }

        return dp[0][0];
    }

    // With memoization the TC gets down to O(s1*s2). Cached based on the i and j pointers
//    private final Map<List<Integer>, Boolean> cache = new HashMap<>();
//
//    public boolean isInterleave(String s1, String s2, String s3) {
//        if (s3.length() != (s1.length() + s2.length())) {
//            return false;
//        }
//
//        return dfs(0, s1, 0, s2, s3);
//    }
//
//    private boolean dfs(int i, String s1, int j, String s2, String s3) {
//        if (i == s1.length() && j == s2.length()) {
//            return true;
//        }
//        if (cache.containsKey(List.of(i, j))) {
//            return cache.get(List.of(i, j));
//        }
//
//        boolean result = false;
//        int k = i + j;
//        if (i < s1.length() && j < s2.length() && s1.charAt(i) == s3.charAt(k) && s2.charAt(j) == s3.charAt(k)) {
//            boolean includeS1 = dfs(i + 1, s1, j, s2, s3);
//            boolean includeS2 = dfs(i, s1, j + 1, s2, s3);
//            result = includeS1 || includeS2;
//        } else if (i < s1.length() && s1.charAt(i) == s3.charAt(k)) {
//            result = dfs(i + 1, s1, j, s2, s3);
//        } else if (j < s2.length() && s2.charAt(j) == s3.charAt(k)) {
//            result = dfs(i, s1, j + 1, s2, s3);
//        }
//
//        cache.put(List.of(i, j), result);
//        return result;
//    }


    // TC: O(2^s1+s2)
//    public boolean isInterleave(String s1, String s2, String s3) {
//        if (s3.length() != (s1.length() + s2.length())) {
//            return false;
//        }
//
//        return dfs(0, s1, 0, s2, 0, s3);
//    }
//
//    private boolean dfs(int i, String s1, int j, String s2, int k, String s3) {
//        // If all the pointers are out of bounds - then we found a solution
//        if (k >= s3.length() && i >= s1.length() && j >= s2.length()) {
//            return true;
//        }
//
//        // if i and j are in bounds and both chars equal to the k, then try both of them
//        if (i < s1.length() && j < s2.length() && s1.charAt(i) == s3.charAt(k) && s2.charAt(j) == s3.charAt(k)) {
//            boolean includeS1 = dfs(i + 1, s1, j, s2, k + 1, s3);
//            boolean includeS2 = dfs(i, s1, j + 1, s2, k + 1, s3);
//            return includeS1 || includeS2;
//            // If both are not equal and i equals to the k, then try this
//        } else if (i < s1.length() && s1.charAt(i) == s3.charAt(k)) {
//            return dfs(i + 1, s1, j, s2, k + 1, s3);
//            // If both are not equal and j equals to the k, then try this
//        } else if (j < s2.length() && s2.charAt(j) == s3.charAt(k)) {
//            return dfs(i, s1, j + 1, s2, k + 1, s3);
//        } else {
//            // the case when either non was equal, or the pointers are out of bounds
//            return false;
//        }
//    }
}
