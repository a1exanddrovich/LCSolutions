package com.bliznichenka.advancedgraphs.pathwithminimumeffort_1631;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class Solution {
    public int minimumEffortPath(int[][] heights) {
        // [row, col, diffEffort, maxDiffEffort]
        Queue<List<Integer>> minHeap = new PriorityQueue<>(
                Comparator.comparingInt(list -> list.get(3))
        );

        minHeap.add(List.of(0, 0, 0, 0));
        Set<List<Integer>> visited = new HashSet<>();
        List<List<Integer>> dirs = List.of(
                List.of(0, -1),
                List.of(1, 0),
                List.of(0, 1),
                List.of(-1, 0)
        );

        while (!minHeap.isEmpty()) {
            List<Integer> polled = minHeap.poll();
            int row = polled.get(0);
            int col = polled.get(1);
            int effort = polled.get(2);
            int maxEffort = polled.get(3);

            if (visited.contains(List.of(row, col))) {
                continue;
            }

            if (row == heights.length - 1 && col == heights[0].length - 1) {
                return maxEffort;
            }

            visited.add(List.of(row, col));

            for (List<Integer> dir : dirs) {
                int nextRow = row + dir.get(0);
                int nextCol = col + dir.get(1);

                if (nextRow >= 0 &&
                        nextRow < heights.length &&
                        nextCol >= 0 &&
                        nextCol < heights[0].length &&
                        !visited.contains(List.of(nextRow, nextCol))) {
                    int nextEffort = heights[nextRow][nextCol];
                    int prevEffort = heights[row][col];
                    int diffEffort = Math.abs(nextEffort - prevEffort);
                    minHeap.add(List.of(
                            nextRow,
                            nextCol,
                            Math.abs(nextEffort - prevEffort),
                            Math.max(maxEffort, diffEffort)
                    ));
                }
            }
        }

        return -1;
    }
}
