package com.bliznichenka.dynamicprogramming2d.minimumpathsum_64;

import java.util.Arrays;

public class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[] prevRow = new int[n + 1];
        Arrays.fill(prevRow, Integer.MAX_VALUE);
        // needed to let the Math work out
        prevRow[n - 1] = 0;

        for (int i = m - 1; i >= 0; i--) {
            int[] curRow = new int[n + 1];
            curRow[n] = Integer.MAX_VALUE;
            for (int j = n - 1; j >= 0; j--) {
                curRow[j] = grid[i][j] + Math.min(curRow[j + 1], prevRow[j]);
            }
            prevRow = curRow;
        }

        return prevRow[0];
    }
}
