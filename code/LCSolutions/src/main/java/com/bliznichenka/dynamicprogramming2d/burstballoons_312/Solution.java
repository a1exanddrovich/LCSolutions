package com.bliznichenka.dynamicprogramming2d.burstballoons_312;

import javafx.util.Pair;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    private final Map<Pair<Integer, Integer>, Integer> cache = new HashMap<>();

    public int maxCoins(int[] nums) {
        int[] array = new int[nums.length + 2];
        array[0] = 1;
        System.arraycopy(nums, 0, array, 1, nums.length);
        array[nums.length + 1] = 1;

        return dfs(array, 1, array.length - 2);
    }

    private int dfs(int[] nums, int l, int r) {
        if (cache.containsKey(new Pair<>(l, r))) {
            return cache.get(new Pair<>(l, r));
        }
        if (l > r) {
            return 0;
        }

        int max = 0;
        for (int i = l; i <= r; i++) {
            int coins = nums[l - 1] * nums[i] * nums[r + 1];

            int resultCoins = coins + dfs(nums, l, i - 1) + dfs(nums, i + 1, r);
            max = Math.max(max, resultCoins);
        }

        cache.put(new Pair<>(l, r), max);
        return max;
    }
}
