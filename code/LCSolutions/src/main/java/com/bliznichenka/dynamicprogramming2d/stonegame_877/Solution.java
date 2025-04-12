package com.bliznichenka.dynamicprogramming2d.stonegame_877;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    private final Map<List<Integer>, List<Integer>> cache = new HashMap<>();

    public boolean stoneGame(int[] piles) {
        List<Integer> result = dfs(piles, 0, piles.length - 1);
        return result.get(0) > result.get(1);
    }

    private List<Integer> dfs(int[] piles, int l, int r) {
        if (l == r) {
            return List.of(piles[l], 0);
        }
        if (cache.containsKey(List.of(l, r))) {
            return cache.get(List.of(l, r));
        }

        List<Integer> chooseLeft = dfs(piles, l + 1, r);
        List<Integer> chooseRight = dfs(piles, l, r - 1);

        List<Integer> resultLeft = List.of(piles[l] + chooseLeft.get(1), chooseLeft.get(0));
        List<Integer> resultRight = List.of(piles[r] + chooseRight.get(1), chooseRight.get(0));

        List<Integer> result =
                resultLeft.get(0) > resultRight.get(0) ? resultLeft : resultRight;

        cache.put(List.of(l, r), result);
        return result;
    }

    // (l, r) -> max Alice score
//    private final Map<List<Integer>, Integer> cache = new HashMap<>();
//
//    public boolean stoneGame(int[] piles) {
//        int sum = 0;
//        for (int pile : piles) {
//            sum += pile;
//        }
//        int score = dfs(piles, 0, piles.length - 1);
//        return score > (sum - score);
//    }
//
//    private int dfs(int[] piles, int l, int r) {
//        if (l > r) {
//            return 0;
//        }
//        if (cache.containsKey(List.of(l, r))) {
//            return cache.get(List.of(l, r));
//        }
//
//        // if even len, then it's Alice choosing, otherwise - Bob
//        boolean even = (r - l) % 2 == 0;
//        int left = even ? piles[l] : 0;
//        int right = even ? piles[r] : 0;
//
//        int result = Math.max(
//                left + dfs(piles, l + 1, r),
//                right + dfs(piles, l, r - 1)
//        );
//
//        cache.put(List.of(l, r), result);
//        return result;
//    }
}
