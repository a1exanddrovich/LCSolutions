package com.bliznichenka.dynamicprogramming2d.besttimetobuyandsellstockwithcooldown_309;

import javafx.util.Pair;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    private final Map<Pair<Integer, Boolean>, Integer> cache = new HashMap<>();

    public int maxProfit(int[] prices) {
        return dfs(0, prices, true);
    }

    private int dfs(int i, int[] prices, boolean buy) {
        if (i >= prices.length) {
            return 0;
        }
        if (cache.containsKey(new Pair<>(i, buy))) {
            return cache.get(new Pair<>(i, buy));
        }

        // cooldown
        int res = dfs(i + 1, prices, buy);
        if (buy) {
            int bought = dfs(i + 1, prices, false) - prices[i];
            res = Math.max(res, bought);
        } else {
            int sold = dfs(i + 2, prices, true) + prices[i];
            res = Math.max(res, sold);
        }

        cache.put(new Pair<>(i, buy), res);
        return res;
    }
}
