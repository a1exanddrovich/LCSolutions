package com.bliznichenka.backtracking.lettercombinationsofaphonenumber_17;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Solution {
    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) {
            return List.of();
        }
        Map<Character, List<Character>> map = Map.of(
                '2', List.of('a', 'b', 'c'),
                '3', List.of('d', 'e', 'f'),
                '4', List.of('g', 'h', 'i'),
                '5', List.of('j', 'k', 'l'),
                '6', List.of('m', 'n', 'o'),
                '7', List.of('p', 'q', 'r', 's'),
                '8', List.of('t', 'u', 'v'),
                '9', List.of('w', 'x', 'y', 'z')
        );
        List<String> result = new ArrayList<>();
        dfs(digits, 0, new StringBuilder(), map, result);
        return result;
    }

    private static void dfs(
            String digits,
            int i,
            StringBuilder cur,
            Map<Character, List<Character>> map,
            List<String> result
    ) {
        if (i >= digits.length()) {
            result.add(cur.toString());
            return;
        }

        for (char c : map.get(digits.charAt(i))) {
            cur.append(c);
            dfs(digits, i + 1, cur, map, result);
            cur.deleteCharAt(cur.length() - 1);
        }
    }
}
