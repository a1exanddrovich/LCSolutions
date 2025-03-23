package com.bliznichenka.backtracking.nqueens_51;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
    public List<List<String>> solveNQueens(int n) {
        Set<Integer> col = new HashSet<>(); // cols
        Set<Integer> posDiag = new HashSet<>(); // row + col
        Set<Integer> negDiag = new HashSet<>(); // row - col

        List<List<String>> result = new ArrayList<>();
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        dfs(0, board, result, n, col, posDiag, negDiag);
        return result;
    }

    private static void dfs(
            int row,
            char[][] board,
            List<List<String>> result,
            int n,
            Set<Integer> col,
            Set<Integer> posDiag,
            Set<Integer> negDiag
    ) {
        if (row >= n) {
            List<String> curBoard = new ArrayList<>();
            for (char[] curRow : board) {
                curBoard.add(new String(curRow));
            }
            result.add(curBoard);
            return;
        }

        for (int c = 0; c < n; c++) {
            if (col.contains(c)
                    || posDiag.contains(row + c)
                    || negDiag.contains(row - c)) {
                continue;
            }

            col.add(c);
            posDiag.add(row + c);
            negDiag.add(row - c);
            board[row][c] = 'Q';
            dfs(row + 1, board, result, n, col, posDiag, negDiag);
            board[row][c] = '.';
            col.remove(c);
            posDiag.remove(row + c);
            negDiag.remove(row - c);
        }
    }
}
