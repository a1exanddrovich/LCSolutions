package com.bliznichenka.dynamicprogramming2d.editdistance_72;

public class Solution {
    // Bottom up dp
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        int[][] dp = new int[n + 1][m + 1];

        int ops = 0;
        for (int i = n; i >= 0; i--) {
            dp[i][m] = ops;
            ops++;
        }
        ops = 0;
        for (int j = m; j >= 0; j--) {
            dp[n][j] = ops;
            ops++;
        }

        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                if (word1.charAt(i) == word2.charAt(j)) {
                    dp[i][j] = dp[i + 1][j + 1];
                } else {
                    int delete = 1 + dp[i][j + 1];
                    int replace = 1 + dp[i + 1][j + 1];
                    int insert = 1 + dp[i + 1][j];

                    dp[i][j] = Math.min(Math.min(delete, replace), insert);
                }
            }
        }

        return dp[0][0];
    }

    // Top down dp
//    private final Map<Pair<Integer, Integer>, Integer> cache = new HashMap<>();
//
//    public int minDistance(String word1, String word2) {
//        return dfs(word1, word2, 0, 0);
//    }
//
//    private int dfs(String w1, String w2, int i, int j) {
//        if (i == w1.length() && j == w2.length()) {
//            return 0;
//        }
//        if (i == w1.length()) {
//            return w2.length() - j;
//        }
//        if (j == w2.length()) {
//            return w1.length() - i;
//        }
//        if (cache.containsKey(new Pair<>(i, j))) {
//            return cache.get(new Pair<>(i, j));
//        }
//
//        int result = 0;
//        if (w1.charAt(i) == w2.charAt(j)) {
//            result = dfs(w1, w2, i + 1, j + 1);
//        } else {
//            result++;
//            int replace = dfs(w1, w2, i + 1, j + 1);
//            int delete = dfs(w1, w2, i + 1, j);
//            int insert = dfs(w1, w2, i, j + 1);
//
//            result += Math.min(Math.min(replace, delete), insert);
//        }
//
//        cache.put(new Pair<>(i, j), result);
//        return result;
//    }
}
