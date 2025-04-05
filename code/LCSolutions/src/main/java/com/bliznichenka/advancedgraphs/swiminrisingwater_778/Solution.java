package com.bliznichenka.advancedgraphs.swiminrisingwater_778;

import javafx.util.Pair;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class Solution {
    public int swimInWater(int[][] grid) {
        // [row, col, value]
        Queue<List<Integer>> minHeap = new PriorityQueue<>(
                Comparator.comparingInt(l -> l.get(2)));
        // [row, col]
        Set<Pair<Integer, Integer>> visited = new HashSet<>();
        List<List<Integer>> dirs = List.of(
                List.of(0, -1),
                List.of(1, 0),
                List.of(0, 1),
                List.of(-1, 0));

        minHeap.add(List.of(0, 0, grid[0][0]));
        while (!minHeap.isEmpty()) {
            List<Integer> polled = minHeap.poll();
            int row = polled.get(0);
            int col = polled.get(1);
            int val = polled.get(2);

            if (visited.contains(new Pair<>(row, col))) {
                continue;
            }
            visited.add(new Pair<>(row, col));

            if (row == grid.length - 1 && col == grid[0].length - 1) {
                return val;
            }

            for (List<Integer> dir : dirs) {
                int nextRow = row + dir.get(0);
                int nextCol = col + dir.get(1);
                if (visited.contains(new Pair<>(nextRow, nextCol))
                        || nextRow < 0 || nextRow >= grid.length
                        || nextCol < 0 || nextCol >= grid[0].length) {
                    continue;
                }
                minHeap.add(List.of(nextRow, nextCol, Math.max(val, grid[nextRow][nextCol])));
            }
        }

        return -1;
    }
}
