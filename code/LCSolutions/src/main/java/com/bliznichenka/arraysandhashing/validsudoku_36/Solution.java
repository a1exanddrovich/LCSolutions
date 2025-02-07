package com.bliznichenka.arraysandhashing.validsudoku_36;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {
    public boolean isValidSudoku(char[][] board) {
        Map<Integer, Set<Character>> rows = new HashMap<>();
        Map<Integer, Set<Character>> cols = new HashMap<>();
        Map<String, Set<Character>> boxes = new HashMap<>();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '.') {
                    continue;
                }

                if (rows.containsKey(i) && rows.get(i).contains(board[i][j])
                        || cols.containsKey(j) && cols.get(j).contains(board[i][j])
                        || boxes.containsKey(i / 3 + ":" + j / 3) && boxes.get(i / 3 + ":" + j / 3).contains(board[i][j])) {
                    return false;
                }

                if (!rows.containsKey(i)) {
                    rows.put(i, new HashSet<>());
                }

                if (!cols.containsKey(j)) {
                    cols.put(j, new HashSet<>());
                }

                if (!boxes.containsKey(i / 3 + ":" + j / 3)) {
                    boxes.put(i / 3 + ":" + j / 3, new HashSet<>());
                }

                rows.get(i).add(board[i][j]);
                cols.get(j).add(board[i][j]);
                boxes.get(i / 3 + ":" + j / 3).add(board[i][j]);
            }
        }

        return true;
    }
}
