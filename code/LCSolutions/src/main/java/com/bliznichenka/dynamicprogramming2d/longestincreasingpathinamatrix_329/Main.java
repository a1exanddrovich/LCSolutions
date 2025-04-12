package com.bliznichenka.dynamicprogramming2d.longestincreasingpathinamatrix_329;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();

        int[][] m = {{7, 8, 9}, {9, 7, 6}, {7, 2, 3}};
        System.out.println(s.longestIncreasingPath(m));
    }
}
