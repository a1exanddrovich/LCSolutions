package com.bliznichenka.graphs.wallsandgates_286;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();

        int[][] grid = {
                {2147483647,-1,0,2147483647},
                {2147483647,2147483647,2147483647,-1},
                {2147483647,-1,2147483647,-1},
                {0,-1,2147483647,2147483647}
        };
        print(grid);
        s.wallsAndGates(grid);
        print(grid);
    }

    private static void print(int[][] grid) {
        System.out.println("Outputting");
        for (int[] ints : grid) {
            System.out.println(Arrays.toString(ints));
        }
    }
}
