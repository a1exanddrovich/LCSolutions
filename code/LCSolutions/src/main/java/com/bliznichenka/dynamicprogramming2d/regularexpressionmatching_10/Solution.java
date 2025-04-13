package com.bliznichenka.dynamicprogramming2d.regularexpressionmatching_10;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    private final Map<List<Integer>, Boolean> cache = new HashMap<>();

    public boolean isMatch(String s, String p) {
        return dfs(s, p, 0, 0);
    }

    private boolean dfs(String s, String p, int i, int j) {
        if (cache.containsKey(List.of(i, j))) {
            return cache.get(List.of(i, j));
        }
        if (i >= s.length() && j >= p.length()) {
            return true;
        }
        if (j >= p.length()) {
            return false;
        }

        boolean match = i < s.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.');

        if (j + 1 < p.length() && p.charAt(j + 1) == '*') {
            boolean skip = dfs(s, p, i, j + 2);
            boolean use = match && dfs(s, p, i + 1, j);
            return skip || use;
        }

        boolean res = false;

        if (match) {
            res = dfs(s, p, i + 1, j + 1);
        }
        cache.put(List.of(i, j), res);
        return res;
    }
}
