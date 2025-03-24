package com.bliznichenka.graphs.islandperimeter_463;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();

        int[][] grid = {
                {0, 1, 0, 0},
                {1, 1, 1, 0},
                {0, 1, 0, 0},
                {1, 1, 0, 0}
        };
        System.out.println(s.islandPerimeter(grid));
    }
}
