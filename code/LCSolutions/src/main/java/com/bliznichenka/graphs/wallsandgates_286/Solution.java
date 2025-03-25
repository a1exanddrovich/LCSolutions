package com.bliznichenka.graphs.wallsandgates_286;


import javafx.util.Pair;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
    public void wallsAndGates(int[][] rooms) {
        Deque<Pair<Integer, Integer>> deque = new ArrayDeque<>();
        Set<Pair<Integer, Integer>> visited = new HashSet<>();

        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[i].length; j++) {
                if (rooms[i][j] == 0) {
                    Pair<Integer, Integer> pair = new Pair<>(i, j);
                    deque.addFirst(pair);
                    visited.add(pair);
                }
            }
        }

        while (!deque.isEmpty()) {
            Pair<Integer, Integer> polled = deque.pollLast();
            int row = polled.getKey();
            int col = polled.getValue();
            int prevStepsNumber = rooms[row][col];

            List<List<Integer>> dirs = List.of(
                    List.of(0, -1),
                    List.of(1, 0),
                    List.of(0, 1),
                    List.of(-1, 0)
            );
            for (List<Integer> dir : dirs) {
                int nextI = row + dir.get(0);
                int nextJ = col + dir.get(1);
                if (nextI >= 0 && nextI < rooms.length
                        && nextJ >= 0 && nextJ < rooms[0].length
                        && rooms[nextI][nextJ] != -1
                        && !visited.contains(new Pair<>(nextI, nextJ))) {
                    Pair<Integer, Integer> nextPair = new Pair<>(nextI, nextJ);
                    deque.addFirst(nextPair);
                    visited.add(nextPair);
                    rooms[nextI][nextJ] = prevStepsNumber + 1;
                }
            }
        }
    }
}
