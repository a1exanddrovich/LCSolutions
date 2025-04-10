package com.bliznichenka.dynamicprogramming2d.uniquepathsii_63;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();

        int[][] obstacleGrid = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        System.out.println(s.uniquePathsWithObstacles(obstacleGrid));
    }
}
