package com.bliznichenka.dynamicprogramming1d.coinchange_322;

import java.util.Arrays;

public class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;

        for (int curAmount = 1; curAmount <= amount; curAmount++) {
            for (int coin : coins) {
                int leftAmount = curAmount - coin;
                if (leftAmount >= 0) {
                    dp[curAmount] = Math.min(dp[curAmount], 1 + dp[leftAmount]);
                }
            }
        }

        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }
}
