package com.bliznichenka.dynamicprogramming2d.minimumcostfortickets_983;

import java.util.Map;

public class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        Map<Integer, Integer> map = Map.of(0, 1, 1, 7, 2, 30);
        int[] dp = new int[days.length + 1];

        for (int i = days.length - 1; i >= 0; i--) {
            int sumCost = Integer.MAX_VALUE;
            for (int j = 0; j < 3; j++) {
                int k = i + 1;
                while (k < days.length && days[k] < days[i] + map.get(j)) {
                    k++;
                }
                sumCost = Math.min(sumCost, costs[j] + dp[k]);
            }
            dp[i] = sumCost;
        }

        return dp[0];
    }
}
