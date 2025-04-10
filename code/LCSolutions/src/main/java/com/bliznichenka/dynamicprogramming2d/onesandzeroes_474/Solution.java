package com.bliznichenka.dynamicprogramming2d.onesandzeroes_474;

public class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] prevDp = new int[n + 1][m + 1];

        int[] word = split(strs[0]);
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                if (i >= word[0] && j >= word[1]) {
                    prevDp[i][j] = 1;
                }
            }
        }

        for (int k = 1; k < strs.length; k++) {
            int[][] curDp = new int[n + 1][m + 1];
            word = split(strs[k]);

            for (int i = 0; i <= n; i++) {
                for (int j = 0; j <= m; j++) {
                    int res = prevDp[i][j];
                    if (i - word[0] >= 0 && j - word[1] >= 0) {
                        res = Math.max(
                                res,
                                1 + prevDp[i - word[0]][j - word[1]]
                        );
                    }
                    curDp[i][j] = res;
                }
            }

            prevDp = curDp;
        }

        return prevDp[n][m];
    }

    private static int[] split(String s) {
        int[] res = new int[2];
        for (char c : s.toCharArray()) {
            if (c == '1') {
                res[0]++;
            } else {
                res[1]++;
            }
        }
        return res;
    }

    // [index, zeros, ones]
//    private final Map<List<Integer>, Integer> cache = new HashMap<>();
//
//    public int findMaxForm(String[] strs, int m, int n) {
//        int[][] data = new int[strs.length][];
//        for (int i = 0; i < strs.length; i++) {
//            data[i] = new int[2];
//            for (char c : strs[i].toCharArray()) {
//                if (c == '0') {
//                    data[i][0]++;
//                } else {
//                    data[i][1]++;
//                }
//            }
//        }
//
//        return dfs(data, 0, m, n);
//    }
//
//    private int dfs(int[][] data, int i, int m, int n) {
//        if (i >= data.length) {
//            return 0;
//        }
//        if (cache.containsKey(List.of(i, m, n))) {
//            return cache.get(List.of(i, m, n));
//        }
//
//        int res = dfs(data, i + 1, m, n);
//        if (m - data[i][0] >= 0 && n - data[i][1] >= 0) {
//            res = Math.max(res, 1 + dfs(data, i + 1, m - data[i][0], n - data[i][1]));
//        }
//
//        cache.put(List.of(i, m, n), res);
//        return res;
//    }
}
