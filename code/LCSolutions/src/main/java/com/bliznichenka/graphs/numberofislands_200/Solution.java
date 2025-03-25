package com.bliznichenka.graphs.numberofislands_200;

import javafx.util.Pair;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
    public int numIslands(char[][] grid) {
        Set<Pair<Integer, Integer>> visited = new HashSet<>();
        int result = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1' && !visited.contains(new Pair<>(i, j))) {
                    dfs(grid, i, j, visited);
                    result++;
                }
            }
        }

        return result;
    }

    private static void dfs(
            char[][] grid,
            int i,
            int j,
            Set<Pair<Integer, Integer>> visited
    ) {
        if (i < 0 || i >= grid.length
                || j < 0 || j >= grid[i].length
                || grid[i][j] == '0'
                || visited.contains(new Pair<>(i, j))) {
            return;
        }

        visited.add(new Pair<>(i, j));
        List<List<Integer>> dirs = List.of(
                List.of(0, -1),
                List.of(1, 0),
                List.of(0, 1),
                List.of(-1, 0)
        );
        for (List<Integer> dir : dirs) {
            dfs(grid, i + dir.get(0), j + dir.get(1), visited);
        }
    }
}
