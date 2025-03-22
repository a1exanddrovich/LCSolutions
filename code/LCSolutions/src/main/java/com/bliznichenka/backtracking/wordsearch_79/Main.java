package com.bliznichenka.backtracking.wordsearch_79;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();

        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        String word = "SEE";

        System.out.println(s.exist(board, word));
    }
}
