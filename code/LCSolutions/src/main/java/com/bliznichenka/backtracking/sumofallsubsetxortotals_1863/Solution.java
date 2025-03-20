package com.bliznichenka.backtracking.sumofallsubsetxortotals_1863;

public class Solution {
    public int subsetXORSum(int[] nums) {
        return dfs(nums, 0, 0);
    }

    private static int dfs(int[] nums, int i, int curSum) {
        if (i == nums.length) {
            return curSum;
        }

        int xoredCurSum = curSum ^ nums[i];
        return dfs(nums, i + 1, xoredCurSum)
                + dfs(nums, i + 1, curSum);
    }

//    public int subsetXORSum(int[] nums) {
//        int res = 0;
//        for (int n : nums) {
//            res |= n;
//        }
//
//        return (int) ((double) res * Math.pow(2, nums.length - 1));
//    }
}
