package com.bliznichenka.dynamicprogramming1d.stonegameiii_1406;


public class Solution {
    public String stoneGameIII(int[] stoneValue) {
        // [best value for the player, best value for another player after the first player's move]
        int[][] dp = new int[stoneValue.length + 3][2];
        dp[stoneValue.length + 2] = new int[]{0, 0};
        dp[stoneValue.length + 1] = new int[]{0, 0};
        dp[stoneValue.length] = new int[]{0, 0};

        for (int i = stoneValue.length - 1; i >= 0; i--) {
            int curSum = stoneValue[i];
            int[] bestVariant = {curSum + dp[i + 1][1], dp[i + 1][0]};
            int j = 1;
            while (i + j < stoneValue.length && j < 3) {
                curSum += stoneValue[i + j];
                int nextPossibleBestValue = curSum + dp[i + j + 1][1];
                if (nextPossibleBestValue > bestVariant[0]) {
                    bestVariant = new int[]{nextPossibleBestValue, dp[i + j + 1][0]};
                }
                j++;
            }
            dp[i] = bestVariant;
        }

        if (dp[0][0] > dp[0][1]) {
            return "Alice";
        } else if (dp[0][0] < dp[0][1]) {
            return "Bob";
        } else {
            return "Tie";
        }
    }
}
