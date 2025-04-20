package com.bliznichenka.graphs.shortestpathinbinarymatrix_1091;

import javafx.util.Pair;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;

        if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1) {
            return -1;
        }

        int[][] directions = {
                {-1, 0},
                {-1, -1},
                {0, -1},
                {1, -1},
                {1, 0},
                {1, 1},
                {0, 1},
                {-1, 1}
        };

        Set<Pair<Integer, Integer>> visited = new HashSet<>();
        Deque<Pair<Integer, Integer>> deque = new ArrayDeque<>();

        deque.addFirst(new Pair<>(0, 0));
        visited.add(new Pair<>(0, 0));

        int steps = 1;
        while (!deque.isEmpty()) {
            int len = deque.size();

            for (int inc = 0; inc < len; inc++) {
                Pair<Integer, Integer> pair = deque.pollLast();
                int i = pair.getKey();
                int j = pair.getValue();

                if (i == n - 1 && j == n - 1) {
                    return steps;
                }

                for (int[] dir : directions) {
                    int nextI = i + dir[0];
                    int nextJ = j + dir[1];

                    if (nextI < 0 || nextI >= n
                            || nextJ < 0 || nextJ >= n
                            || visited.contains(new Pair<>(nextI, nextJ))
                            || grid[nextI][nextJ] == 1) {
                        continue;
                    }
                    deque.addFirst(new Pair<>(nextI, nextJ));
                    visited.add(new Pair<>(nextI, nextJ));
                }

            }

            steps++;
        }

        return -1;
    }
}
