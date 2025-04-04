package com.bliznichenka.advancedgraphs.pathwithminimumeffort_1631;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();

        int[][] heights = {
                {1, 2, 2},
                {3, 8, 2},
                {5, 3, 5}
        };
        System.out.println(s.minimumEffortPath(heights));
    }
}
