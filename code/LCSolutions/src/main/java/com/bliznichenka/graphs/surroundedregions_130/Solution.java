package com.bliznichenka.graphs.surroundedregions_130;

import javafx.util.Pair;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public void solve(char[][] board) {
        Set<Pair<Integer, Integer>> visited = new HashSet<>();

        for (int j = 0; j < board[0].length; j++) {
            dfs(board, 0, j, visited);
            dfs(board, board.length - 1, j, visited);
        }
        for (int i = 0; i < board.length; i++) {
            dfs(board, i, 0, visited);
            dfs(board, i, board[0].length - 1, visited);
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'O' && !visited.contains(new Pair<>(i, j))) {
                    board[i][j] = 'X';
                }
            }
        }
    }

    private static void dfs(
            char[][] board,
            int i,
            int j,
            Set<Pair<Integer, Integer>> visited
    ) {
        if (i < 0 || i >= board.length
                || j < 0 || j >= board[0].length
                || board[i][j] == 'X'
                || visited.contains(new Pair<>(i, j))) {
            return;
        }

        visited.add(new Pair<>(i, j));
        dfs(board, i, j - 1, visited);
        dfs(board, i + 1, j, visited);
        dfs(board, i, j + 1, visited);
        dfs(board, i - 1, j, visited);
    }
}
