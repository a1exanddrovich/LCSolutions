package com.bliznichenka.dynamicprogramming2d.laststoneweightii_1049;

import javafx.util.Pair;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    private final Map<Pair<Integer, Integer>, Integer> cache = new HashMap<>();

    public int lastStoneWeightII(int[] stones) {
        int stoneSum = 0;
        for (int stone : stones) {
            stoneSum += stone;
        }
        int target = (int) Math.ceil((double) stoneSum / 2);

        return dfs(stones, 0, 0, target, stoneSum);
    }

    private int dfs(int[] stones, int i, int curTotal, int target, int stoneSum) {
        if (curTotal >= target || i >= stones.length) {
            return Math.abs(curTotal - (stoneSum - curTotal));
        }
        if (cache.containsKey(new Pair<>(i, curTotal))) {
            return cache.get(new Pair<>(i, curTotal));
        }

        int skip = dfs(stones, i + 1, curTotal, target, stoneSum);
        int include = dfs(stones, i + 1, curTotal + stones[i], target, stoneSum);
        int result = Math.min(skip, include);

        cache.put(new Pair<>(i, curTotal), result);
        return result;
    }
}
