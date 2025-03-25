package com.bliznichenka.graphs.numberofislands_200;

import javafx.util.Pair;

import java.util.*;

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

    private static void bfs(
            char[][] grid,
            int i,
            int j,
            Set<Pair<Integer, Integer>> visited
    ) {
        Deque<Pair<Integer, Integer>> deque = new ArrayDeque<>();

        Pair<Integer, Integer> pair = new Pair<>(i, j);
        visited.add(pair);
        deque.addFirst(pair);
        while (!deque.isEmpty()) {
            Pair<Integer, Integer> polled = deque.pollLast();
            int row = polled.getKey();
            int col = polled.getValue();

            List<List<Integer>> dirs = List.of(
                    List.of(0, -1),
                    List.of(1, 0),
                    List.of(0, 1),
                    List.of(-1, 0)
            );
            for (List<Integer> dir : dirs) {
                int nextI = row + dir.get(0);
                int nextJ = col + dir.get(1);
                if (nextI >= 0 && nextI < grid.length
                        && nextJ >= 0 && nextJ < grid[0].length
                        && !visited.contains(new Pair<>(nextI, nextJ))
                        && grid[nextI][nextJ] == '1') {
                    Pair<Integer, Integer> nextPair = new Pair<>(nextI, nextJ);
                    visited.add(nextPair);
                    deque.addFirst(nextPair);
                }
            }
        }
    }
}
