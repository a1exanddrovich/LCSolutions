package com.bliznichenka.graphs.pacificatlanticwaterflow_417;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        Set<List<Integer>> canReachPacific = new HashSet<>();
        Set<List<Integer>> canReachAtlantic = new HashSet<>();

        int rows = heights.length;
        int cols = heights[0].length;

        for (int j = 0; j < cols; j++) {
            dfs(heights, 0, j, heights[0][j], canReachPacific);
            dfs(heights, rows - 1, j, heights[rows - 1][j], canReachAtlantic);
        }
        for (int i = 0; i < rows; i++) {
            dfs(heights, i, 0, heights[i][0], canReachPacific);
            dfs(heights, i, cols - 1, heights[i][cols - 1], canReachAtlantic);
        }

        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (canReachPacific.contains(List.of(i, j))
                        && canReachAtlantic.contains(List.of(i, j))) {
                    result.add(List.of(i, j));
                }
            }
        }

        return result;
    }

    private static void dfs(
            int[][] heights,
            int i,
            int j,
            int prevHeight,
            Set<List<Integer>> visited
    ) {
        if (i < 0 || i >= heights.length
                || j < 0 || j >= heights[0].length
                || visited.contains(List.of(i, j))
                || heights[i][j] < prevHeight) {
            return;
        }

        visited.add(List.of(i, j));
        dfs(heights, i, j - 1, heights[i][j], visited);
        dfs(heights, i + 1, j, heights[i][j], visited);
        dfs(heights, i, j + 1, heights[i][j], visited);
        dfs(heights, i - 1, j, heights[i][j], visited);
    }
}
