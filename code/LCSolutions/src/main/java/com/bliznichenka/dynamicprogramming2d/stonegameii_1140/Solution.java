package com.bliznichenka.dynamicprogramming2d.stonegameii_1140;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    private final Map<List<Integer>, Integer> cache = new HashMap<>();

    public int stoneGameII(int[] piles) {
        return dfs(0, 0, 1, piles);
    }

    // returns alice score
    private int dfs(int alice, int i, int m, int[] piles) {
        if (i >= piles.length) {
            return 0;
        }
        if (cache.containsKey(List.of(i, m, alice))) {
            return cache.get(List.of(i, m, alice));
        }

        int result = alice == 0 ? 0 : Integer.MAX_VALUE;
        int pilesSum = 0;
        for (int x = 1; x <= 2 * m; x++) {
            if (i + x > piles.length) {
                break;
            }
            pilesSum += piles[i + x - 1];
            if (alice == 0) {
                result = Math.max(
                        result,
                        pilesSum + dfs(1, i + x, Math.max(m, x), piles)
                );
            } else {
                result = Math.min(
                        result,
                        dfs(0, i + x, Math.max(m, x), piles)
                );
            }
        }

        cache.put(List.of(i, m, alice), result);
        return result;
    }
}
