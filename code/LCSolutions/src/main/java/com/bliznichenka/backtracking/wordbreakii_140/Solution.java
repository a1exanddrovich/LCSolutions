package com.bliznichenka.backtracking.wordbreakii_140;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> result = new ArrayList<>();
        dfs(s, 0, new HashSet<>(wordDict), result, new ArrayList<>());
        return result;
    }

    private static void dfs(
            String s,
            int startIndex,
            Set<String> set,
            List<String> result,
            List<String> cur
    ) {
        if (startIndex >= s.length()) {
            result.add(String.join(" ", cur));
            return;
        }

        for (int i = startIndex; i < s.length(); i++) {
            String sub = s.substring(startIndex, i + 1);
            if (set.contains(sub)) {
                cur.add(sub);
                dfs(s, i + 1, set, result, cur);
                cur.remove(cur.size() - 1);
            }
        }
    }
}
