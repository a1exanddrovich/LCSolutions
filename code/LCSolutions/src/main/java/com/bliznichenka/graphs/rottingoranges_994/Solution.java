package com.bliznichenka.graphs.rottingoranges_994;

import javafx.util.Pair;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
    public int orangesRotting(int[][] grid) {
        Deque<Pair<Integer, Integer>> deque = new ArrayDeque<>();
        Set<Pair<Integer, Integer>> visited = new HashSet<>();
        int freshCount = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    freshCount++;
                } else if (grid[i][j] == 2) {
                    deque.addFirst(new Pair<>(i, j));
                    visited.add(new Pair<>(i, j));
                }
            }
        }

        int time = 0;
        List<List<Integer>> dirs = List.of(
                List.of(0, -1),
                List.of(1, 0),
                List.of(0, 1),
                List.of(-1, 0)
        );
        while (!deque.isEmpty() && freshCount > 0) {
            int len = deque.size();
            for (int i = 0; i < len; i++) {
                Pair<Integer, Integer> polled = deque.pollLast();
                int row = polled.getKey();
                int col = polled.getValue();

                for (List<Integer> dir : dirs) {
                    int nextRow = row + dir.get(0);
                    int nextCol = col + dir.get(1);
                    if (nextRow >= 0 && nextRow < grid.length
                            && nextCol >= 0 && nextCol < grid[0].length
                            && !visited.contains(new Pair<>(nextRow, nextCol))
                            && grid[nextRow][nextCol] == 1) {
                        Pair<Integer, Integer> nextPair = new Pair<>(nextRow, nextCol);
                        deque.addFirst(nextPair);
                        visited.add(nextPair);
                        freshCount--;
                    }
                }
            }
            time++;
        }

        return freshCount == 0 ? time : -1;
    }
}
