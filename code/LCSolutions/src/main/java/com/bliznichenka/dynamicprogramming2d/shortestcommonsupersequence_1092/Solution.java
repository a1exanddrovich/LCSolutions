package com.bliznichenka.dynamicprogramming2d.shortestcommonsupersequence_1092;

public class Solution {

    public String shortestCommonSupersequence(String str1, String str2) {
        int n = str2.length();
        int m = str1.length();
        String[] prevDp = new String[m + 1];

        prevDp[m] = "";
        StringBuilder additional = new StringBuilder(str1);
        for (int j = 0; j < m; j++) {
            prevDp[j] = additional.toString();
            additional.deleteCharAt(0);
        }

        for (int i = n - 1; i >= 0; i--) {
            String[] dp = new String[m + 1];
            dp[m] = str2.substring(i);
            for (int j = m - 1; j >= 0; j--) {
                if (str1.charAt(j) == str2.charAt(i)) {
                    dp[j] = str1.charAt(j) + prevDp[j + 1];
                } else {
                    String first = str1.charAt(j) + dp[j + 1];
                    String second = str2.charAt(i) + prevDp[j];
                    dp[j] = first.length() < second.length() ? first : second;
                }
            }
            prevDp = dp;
        }

        return prevDp[0];
    }

//    private final Map<Pair<Integer, Integer>, String> cache = new HashMap<>();
//
//    public String shortestCommonSupersequence(String str1, String str2) {
//        return dfs(str1, str2, 0, 0);
//    }
//
//    private String dfs(String str1, String str2, int i, int j) {
//        if (cache.containsKey(new Pair<>(i, j))) {
//            return cache.get(new Pair<>(i, j));
//        }
//        if (i == str1.length()) {
//            return str2.substring(j);
//        }
//        if (j == str2.length()) {
//            return str1.substring(i);
//        }
//
//        String result;
//        if (str1.charAt(i) == str2.charAt(j)) {
//            result = str1.charAt(i) + dfs(str1, str2, i + 1, j + 1);
//        } else {
//            String first = str2.charAt(j) + dfs(str1, str2, i, j + 1);
//            String second = str1.charAt(i) + dfs(str1, str2, i + 1, j);
//            result = first.length() < second.length() ? first : second;
//        }
//
//        cache.put(new Pair<>(i, j), result);
//        return result;
//    }
}
