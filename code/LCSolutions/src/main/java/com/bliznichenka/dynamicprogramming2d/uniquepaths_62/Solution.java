package com.bliznichenka.dynamicprogramming2d.uniquepaths_62;

public class Solution {
    public int uniquePaths(int m, int n) {
        int[] dp = new int[n];

        for (int row = 0; row < m; row++) {
            int[] nextDp = new int[n];
            nextDp[0] = 1;
            for (int col = 1; col < n; col++) {
                nextDp[col] = nextDp[col - 1] + dp[col];
            }
            dp = nextDp;
        }

        return dp[n - 1];
    }
}
