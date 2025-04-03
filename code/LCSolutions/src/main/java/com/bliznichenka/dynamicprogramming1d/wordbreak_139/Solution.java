package com.bliznichenka.dynamicprogramming1d.wordbreak_139;

import java.util.List;

public class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[s.length()] = true;

        for (int i = s.length() - 1; i >= 0; i--) {
            for (String w : wordDict) {
                if (i + w.length() <= s.length() &&
                        s.substring(i, i + w.length()).equals(w) &&
                        dp[i + w.length()]) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[0];
    }
}
