package com.bliznichenka.dynamicprogramming2d.maximalsquare_221;

public class Solution {
    public int maximalSquare(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[] dp = new int[m + 1];

        int max = 0;
        for (int i = n - 1; i >= 0; i--) {
            int[] nextDp = new int[m + 1];
            for (int j = m - 1; j >= 0; j--) {
                if (matrix[i][j] == '1') {
                    nextDp[j] = 1 + Math.min(Math.min(dp[j], dp[j + 1]), nextDp[j + 1]);
                }
                max = Math.max(max, nextDp[j] * nextDp[j]);
            }
            dp = nextDp;
        }

        return max;
    }

//    public int maximalSquare(char[][] matrix) {
//        int n = matrix.length;
//        int m = matrix[0].length;
//        int[][] dp = new int[n + 1][m + 1];
//
//        int max = 0;
//        for (int i = n - 1; i >= 0; i--) {
//            for (int j = m - 1; j >= 0; j--) {
//                if (matrix[i][j] == '1') {
//                    dp[i][j] = 1 + Math.min(Math.min(dp[i + 1][j], dp[i + 1][j + 1]), dp[i][j + 1]);
//                }
//                max = Math.max(max, dp[i][j] * dp[i][j]);
//            }
//        }
//
//        return max;
//    }


    // (r, c) -> maxLength
//    private final Map<List<Integer>, Integer> cache = new HashMap<>();
//
//    public int maximalSquare(char[][] matrix) {
//        dfs(matrix, 0, 0);
//
//        int res = 0;
//
//        for (int len : cache.values()) {
//            res = Math.max(res, len);
//        }
//
//        return res * res;
//    }
//
//    private int dfs(char[][] matrix, int r, int c) {
//        if (r >= matrix.length || c >= matrix[0].length) {
//            return 0;
//        }
//
//        if (cache.containsKey(List.of(r, c))) {
//            return cache.get(List.of(r, c));
//        }
//
//        int max = 0;
//
//        int down = dfs(matrix, r + 1, c);
//        int right = dfs(matrix, r, c + 1);
//        int diagonal = dfs(matrix, r + 1, c + 1);
//
//        if (matrix[r][c] == '1') {
//            max = 1 + Math.min(down, Math.min(right, diagonal));
//        }
//
//        cache.put(List.of(r, c), max);
//        return max;
//    }
}
