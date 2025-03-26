package com.bliznichenka.graphs.rottingoranges_994;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();

        int[][] grid = {
                {2, 1, 1},
                {1, 1, 0},
                {0, 1, 1}
        };
        System.out.println(s.orangesRotting(grid));
    }
}
