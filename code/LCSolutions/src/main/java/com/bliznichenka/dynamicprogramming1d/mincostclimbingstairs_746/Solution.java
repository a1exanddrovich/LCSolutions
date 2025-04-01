package com.bliznichenka.dynamicprogramming1d.mincostclimbingstairs_746;

public class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int two = 0;
        int one = cost[cost.length - 1];

        for (int i = cost.length - 2; i >= 0; i--) {
            int temp = cost[i] + Math.min(two, one);
            two = one;
            one = temp;
        }

        return Math.min(one, two);
    }
}
