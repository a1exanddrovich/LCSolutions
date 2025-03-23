package com.bliznichenka.backtracking.partitiontokequalsumsubsets_698;

public class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for (int n : nums) {
            sum += n;
        }

        if (sum % k != 0) {
            return false;
        }

        boolean[] used = new boolean[nums.length];
        return dfs(nums, k, used, sum / k, 0, 0);
    }

    private static boolean dfs(
            int[] nums,
            int k,
            boolean[] used,
            int targetSum,
            int subsetSum,
            int startIndex
    ) {
        if (k == 0) {
            return true;
        }

        if (subsetSum == targetSum) {
            return dfs(nums, k - 1, used, targetSum, 0, 0);
        }

        for (int i = startIndex; i < nums.length; i++) {
            if (!used[i] && subsetSum + nums[i] <= targetSum) {
                used[i] = true;
                if (dfs(nums, k, used, targetSum, subsetSum + nums[i], i + 1)) {
                    return true;
                }
                used[i] = false;
            }
        }

        return false;
    }
}
