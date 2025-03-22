package com.bliznichenka.backtracking.wordsearch_79;

import javafx.util.Pair;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (dfs(board, i, j, word, 0, new HashSet<>())) {
                    return true;
                }
            }
        }

        return false;
    }

    private static boolean dfs(
            char[][] board,
            int row,
            int col,
            String word,
            int index,
            Set<Pair<Integer, Integer>> visited
    ) {
        if (index == word.length()) {
            return true;
        }
        if (row < 0 || row >= board.length
                || col < 0 || col >= board[0].length
                || visited.contains(new Pair<>(row, col))
                || board[row][col] != word.charAt(index)) {
            return false;
        }

        visited.add(new Pair<>(row, col));
        List<List<Integer>> dirs = List.of(
                List.of(0, -1),
                List.of(1, 0),
                List.of(0, 1),
                List.of(-1, 0)
        );
        for (List<Integer> dir : dirs) {
            int nextRow = row + dir.get(0);
            int nextCol = col + dir.get(1);
            if (dfs(board, nextRow, nextCol, word, index + 1, visited)) {
                return true;
            }
        }
        visited.remove(new Pair<>(row, col));

        return false;
    }
}
