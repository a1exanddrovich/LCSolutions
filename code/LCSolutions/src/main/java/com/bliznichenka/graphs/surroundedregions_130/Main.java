package com.bliznichenka.graphs.surroundedregions_130;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Solution s = new Solution();

        char[][] board = {
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'X'}
        };
        print(board);
        s.solve(board);
        print(board);
    }

    private static void print(char[][] board) {
        System.out.println("Outputting");
        for (char[] chars : board) {
            System.out.println(Arrays.toString(chars));
        }
    }
}
