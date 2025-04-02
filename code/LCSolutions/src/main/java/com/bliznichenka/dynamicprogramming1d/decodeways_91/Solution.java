package com.bliznichenka.dynamicprogramming1d.decodeways_91;

public class Solution {
    public int numDecodings(String s) {
        int i = s.length() - 1;
        int takeOne = 1;
        int takeTwo = 1;

        while (i >= 0) {
            int res = 0;
            if (s.charAt(i) == '0') {
                takeTwo = takeOne;
                takeOne = res;
                i--;
                continue;
            }

            res = takeOne;

            if (i + 1 < s.length() &&
                    (s.charAt(i) == '1' || (s.charAt(i) == '2' && s.charAt(i + 1) <= '6'))) {
                res += takeTwo;
            }

            takeTwo = takeOne;
            takeOne = res;
            i--;
        }

        return takeOne;
    }

//    public int numDecodings(String s) {
//        int[] dp = new int[s.length() + 1];
//        dp[s.length()] = 1;
//
//        int i = s.length() - 1;
//        while (i >= 0) {
//            if (s.charAt(i) == '0') {
//                i--;
//                continue;
//            }
//
//            int res = dp[i + 1];
//
//            if (i + 1 < s.length() && (s.charAt(i) == '1' || (s.charAt(i) == '2' && s.charAt(i + 1) <= '6'))) {
//                res += dp[i + 2];
//            }
//
//            dp[i] = res;
//            i--;
//        }
//
//        return dp[0];
//    }

//    private final Map<Integer, Integer> cache = new HashMap<>();
//
//    public int numDecodings(String s) {
//        cache.put(s.length(), 1);
//        return dfs(s, 0);
//    }
//
//    private int dfs(String s, int i) {
//        if (cache.containsKey(i)) {
//            return cache.get(i);
//        }
//        if (s.charAt(i) == '0') {
//            return 0;
//        }
//
//        int res = 0;
//        res += dfs(s, i + 1);
//
//        if (i + 1 < s.length() && (s.charAt(i) == '1' || (s.charAt(i) == '2' && s.charAt(i + 1) <= '6'))) {
//            res += dfs(s, i + 2);
//        }
//
//        cache.put(i, res);
//        return res;
//    }

}
