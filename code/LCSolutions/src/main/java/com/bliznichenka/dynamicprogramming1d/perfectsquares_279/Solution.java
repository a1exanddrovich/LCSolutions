package com.bliznichenka.dynamicprogramming1d.perfectsquares_279;

import java.util.Arrays;

public class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, n + 1);
        dp[0] = 0;

        for (int target = 1; target <= n; target++) {
            for (int s = 1; s <= target; s++) {
                int leftTarget = target - (s * s);
                if (leftTarget < 0) {
                    break;
                }
                dp[target] = Math.min(dp[target], 1 + dp[leftTarget]);
            }
        }

        return dp[n];
    }
}
