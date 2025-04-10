package com.bliznichenka.dynamicprogramming2d.uniquepathsii_63;

public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[] prevRow = new int[n];
        prevRow[n - 1] = 1;

        for (int row = m - 1; row >= 0; row--) {
            int[] curRow = new int[n];
            if (obstacleGrid[row][n - 1] == 0) {
                curRow[n - 1] = prevRow[n - 1];
            }
            for (int col = n - 2; col >= 0; col--) {
                if (obstacleGrid[row][col] == 0) {
                    curRow[col] = prevRow[col] + curRow[col + 1];
                }
            }
            prevRow = curRow;
        }

        return prevRow[0];
    }
}
