package com.bliznichenka.graphs.maxareaofisland_695;

import javafx.util.Pair;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        Set<Pair<Integer, Integer>> visited = new HashSet<>();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                maxArea = Math.max(maxArea, dfs(grid, i, j, visited));
            }
        }

        return maxArea;
    }

    private static int dfs(
            int[][] grid,
            int i,
            int j,
            Set<Pair<Integer, Integer>> visited
    ) {
        if (i < 0 || i >= grid.length
            || j < 0 || j >= grid[0].length
            || grid[i][j] == 0
            || visited.contains(new Pair<>(i, j))) {
            return 0;
        }

        visited.add(new Pair<>(i, j));
        int area = 1;

        List<List<Integer>> dirs = List.of(
                List.of(0, -1),
                List.of(1, 0),
                List.of(0, 1),
                List.of(-1, 0)
        );
        for (List<Integer> dir : dirs) {
            area += dfs(grid, i + dir.get(0), j + dir.get(1), visited);
        }

        return area;
    }
}
