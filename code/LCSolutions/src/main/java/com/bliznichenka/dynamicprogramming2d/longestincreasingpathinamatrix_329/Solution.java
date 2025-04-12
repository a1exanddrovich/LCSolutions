package com.bliznichenka.dynamicprogramming2d.longestincreasingpathinamatrix_329;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Solution {
    private final Map<List<Integer>, Integer> cache = new HashMap<>();

    public int longestIncreasingPath(int[][] matrix) {
        int result = 1;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                result = Math.max(result, dfs(matrix, i, j, new HashSet<>()));
            }
        }

        return result;
    }

    private int dfs(int[][] matrix, int i, int j, Set<List<Integer>> visited) {
        if (cache.containsKey(List.of(i, j))) {
            return cache.get(List.of(i, j));
        }

        visited.add(List.of(i, j));
        int maxLen = 0;

        List<List<Integer>> dirs = List.of(
                List.of(-1, 0),
                List.of(0, 1),
                List.of(1, 0),
                List.of(0, -1)
        );
        for (List<Integer> dir : dirs) {
            int nextI = i + dir.get(0);
            int nextJ = j + dir.get(1);
            if (nextI < 0 || nextI >= matrix.length
                    || nextJ < 0 || nextJ >= matrix[0].length
                    || visited.contains(List.of(nextI, nextJ))
                    || matrix[nextI][nextJ] <= matrix[i][j]) {
                continue;
            }
            maxLen = Math.max(maxLen, dfs(matrix, nextI, nextJ, visited));
        }
        visited.remove(List.of(i, j));

        int res = maxLen + 1;
        cache.put(List.of(i, j), res);
        return res;
    }

//    public int longestIncreasingPath(int[][] matrix) {
//        int[][] cache = new int[matrix.length][matrix[0].length];
//        int result = 1;
//
//        for (int i = 0; i < matrix.length; i++) {
//            for (int j = 0; j < matrix[0].length; j++) {
//                result = Math.max(result, dfs(matrix, i, j, cache));
//            }
//        }
//
//        return result;
//    }
//
//    private int dfs(int[][] matrix, int i, int j, int[][] cache) {
//        if (cache[i][j] != 0) {
//            return cache[i][j];
//        }
//
//        int maxLen = 0;
//
//        List<List<Integer>> dirs = List.of(
//                List.of(-1, 0),
//                List.of(0, 1),
//                List.of(1, 0),
//                List.of(0, -1)
//        );
//        for (List<Integer> dir : dirs) {
//            int nextI = i + dir.get(0);
//            int nextJ = j + dir.get(1);
//            if (nextI < 0 || nextI >= matrix.length
//                    || nextJ < 0 || nextJ >= matrix[0].length
//                    || matrix[i][j] >= matrix[nextI][nextJ]) {
//                continue;
//            }
//            maxLen = Math.max(maxLen, dfs(matrix, nextI, nextJ, cache));
//        }
//
//        int res = maxLen + 1;
//        cache[i][j] = res;
//        return res;
//    }
}
