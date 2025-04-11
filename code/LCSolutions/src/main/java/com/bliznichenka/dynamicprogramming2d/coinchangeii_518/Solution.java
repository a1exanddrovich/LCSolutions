package com.bliznichenka.dynamicprogramming2d.coinchangeii_518;

public class Solution {
    public int change(int amount, int[] coins) {
        int[] prevDp = new int[amount + 1];
        prevDp[0] = 1;

        for (int coin : coins) {
            int[] dp = new int[amount + 1];
            dp[0] = 1;
            for (int j = 1; j <= amount; j++) {
                int result = prevDp[j];
                int leftAmount = j - coin;
                if (leftAmount >= 0) {
                    result += dp[leftAmount];
                }
                dp[j] = result;
            }
            prevDp = dp;
        }

        return prevDp[amount];
    }

//    private final Map<List<Integer>, Integer> cache = new HashMap<>();
//
//    public int change(int amount, int[] coins) {
//        return dfs(amount, coins, 0);
//    }
//
//    private int dfs(int amount, int[] coins, int i) {
//        if (amount == 0) {
//            return 1;
//        }
//        if (amount < 0 || i >= coins.length) {
//            return 0;
//        }
//        if (cache.containsKey(List.of(amount, i))) {
//            return cache.get(List.of(amount, i));
//        }
//
//        int res = dfs(amount - coins[i], coins, i);
//        res += dfs(amount, coins, i + 1);
//
//        cache.put(List.of(amount, i), res);
//        return res;
//    }
}
