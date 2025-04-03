package com.bliznichenka.dynamicprogramming1d.combinationsumiv_377;

public class Solution {
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;

        for (int i = 1; i <= target; i++) {
            for (int n : nums) {
                int leftTarget = i - n;
                if (leftTarget >= 0) {
                    dp[i] += dp[leftTarget];
                }
            }
        }

        return dp[target];
    }

//    private final Map<Integer, Integer> cache = new HashMap<>();
//
//    public int combinationSum4(int[] nums, int target) {
//        cache.put(0, 1);
//        return dfs(nums, target);
//    }
//
//    private int dfs(int[] nums, int leftTarget) {
//        if (leftTarget < 0) {
//            return 0;
//        }
//        if (cache.containsKey(leftTarget)) {
//            return cache.get(leftTarget);
//        }
//
//        int res = 0;
//        for (int n : nums) {
//            res += dfs(nums, leftTarget - n);
//        }
//
//        cache.put(leftTarget, res);
//        return res;
//    }

}
