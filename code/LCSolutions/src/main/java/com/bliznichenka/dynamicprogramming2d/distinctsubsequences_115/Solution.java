package com.bliznichenka.dynamicprogramming2d.distinctsubsequences_115;

import javafx.util.Pair;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    private final Map<Pair<Integer, Integer>, Integer> cache = new HashMap<>();

    public int numDistinct(String s, String t) {
        return dfs(s, t, 0, 0);
    }

    private int dfs(String s, String t, int i, int j) {
        if (cache.containsKey(new Pair<>(i, j))) {
            return cache.get(new Pair<>(i, j));
        }
        if (j == t.length()) {
            return 1;
        }
        if (i == s.length()) {
            return 0;
        }

        int result = 0;
        if (s.charAt(i) == t.charAt(j)) {
            result += dfs(s, t, i + 1, j + 1);
            result += dfs(s, t, i + 1, j);
        } else {
            result += dfs(s, t, i + 1, j);
        }

        cache.put(new Pair<>(i, j), result);
        return result;
    }
}
