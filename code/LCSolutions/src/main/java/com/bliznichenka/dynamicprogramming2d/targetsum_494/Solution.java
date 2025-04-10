package com.bliznichenka.dynamicprogramming2d.targetsum_494;

import javafx.util.Pair;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    // [(curSum, index) -> count]
    private final Map<Pair<Integer, Integer>, Integer> cache = new HashMap<>();

    public int findTargetSumWays(int[] nums, int target) {
        return dfs(0, nums, target, 0);
    }

    private int dfs(int i, int[] nums, int target, int curSum) {
        if (cache.containsKey(new Pair<>(curSum, i))) {
            return cache.get(new Pair<>(curSum, i));
        }
        if (i == nums.length) {
            return curSum == target ? 1 : 0;
        }

        int add = dfs(i + 1, nums, target, curSum + nums[i]);
        int subtract = dfs(i + 1, nums, target, curSum - nums[i]);

        int result = add + subtract;
        cache.put(new Pair<>(curSum, i), result);
        return result;
    }
}
