package com.bliznichenka.dynamicprogramming1d.partitionequalsubsetsum_416;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int n : nums) {
            sum += n;
        }

        if (sum % 2 != 0) {
            return false;
        }

        Set<Integer> dp = new HashSet<>();
        dp.add(0);
        for (int i = nums.length - 1; i >= 0; i--) {
            Set<Integer> cur = new HashSet<>();

            for (int n : dp) {
                cur.add(n + nums[i]);
            }

            dp.addAll(cur);
        }

        return dp.contains(sum / 2);
    }

//    // [(leftTarget, index) -> canPartition]
//    private final Map<Pair<Integer, Integer>, Boolean> cache = new HashMap<>();
//
//    public boolean canPartition(int[] nums) {
//        int sum = 0;
//        for (int n : nums) {
//            sum += n;
//        }
//
//        if (sum % 2 != 0) {
//            return false;
//        }
//
//        return dfs(nums, 0, sum / 2);
//    }
//
//    private boolean dfs(int[] nums, int i, int leftTarget) {
//        if (cache.containsKey(new Pair<>(leftTarget, i))) {
//            return cache.get(new Pair<>(leftTarget, i));
//        }
//        if (leftTarget == 0) {
//            return true;
//        }
//        if (i >= nums.length || leftTarget < 0) {
//            return false;
//        }
//
//        boolean canPartitionArray = dfs(nums, i + 1, leftTarget - nums[i]) ||
//                dfs(nums, i + 1, leftTarget);
//
//        cache.put(new Pair<>(leftTarget, i), canPartitionArray);
//        return canPartitionArray;
//    }}
}
