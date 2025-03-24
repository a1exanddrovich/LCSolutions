package com.bliznichenka.graphs.islandperimeter_463;

import javafx.util.Pair;

import java.util.HashSet;
import java.util.Set;
import java.util.List;

public class Solution {
    public int islandPerimeter(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    return dfs(grid, i, j, new HashSet<>());
                }
            }
        }

        return 0;
    }

    private static int dfs(
            int[][] grid,
            int i,
            int j,
            Set<Pair<Integer, Integer>> visited
    ) {
        if (visited.contains(new Pair<>(i, j))) {
            return 0;
        }
        if (i < 0 || i >= grid.length
                || j < 0 || j >= grid[i].length
                || grid[i][j] == 0) {
            return 1;
        }

        int perimeter = 0;
        visited.add(new Pair<>(i, j));
        List<List<Integer>> dirs = List.of(
                List.of(0, -1),
                List.of(1, 0),
                List.of(0, 1),
                List.of(-1, 0)
        );
        for (List<Integer> dir : dirs) {
            perimeter += dfs(grid, i + dir.get(0), j + dir.get(1), visited);
        }
        return perimeter;
    }
}
