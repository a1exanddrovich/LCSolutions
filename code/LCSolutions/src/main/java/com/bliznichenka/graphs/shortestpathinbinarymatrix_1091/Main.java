package com.bliznichenka.graphs.shortestpathinbinarymatrix_1091;

public class Main {

    public static void main(String[] args) {
        Solution s = new Solution();

        int[][] grid = {
                {0, 0, 0},
                {1, 1, 0},
                {1, 1, 0}
        };
        System.out.println(s.shortestPathBinaryMatrix(grid));
    }

}
