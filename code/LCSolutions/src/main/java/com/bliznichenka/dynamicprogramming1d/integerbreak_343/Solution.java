package com.bliznichenka.dynamicprogramming1d.integerbreak_343;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    private final Map<Integer, Integer> cache = new HashMap<>();

    public int integerBreak(int n) {
        cache.put(1, 1);
        return dfs(n, n);
    }

    private int dfs(int n, int num) {
        if (cache.containsKey(num)) {
            return cache.get(num);
        }

        int res = num == n ? 0 : num;

        for (int i = 1; i < num; i++) {
            res = Math.max(res, dfs(n, i) * dfs(n, num - i));
        }
        cache.put(num, res);
        return res;
    }
}
