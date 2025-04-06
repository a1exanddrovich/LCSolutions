package com.bliznichenka.advancedgraphs.buildamatrixwithconditions_2392;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();

        int k = 3;
        int[][] rowConditions = {{1, 2}, {3, 2}};
        int[][] colConditions = {{2, 1}, {3, 2}};
        System.out.println(Arrays.deepToString(s.buildMatrix(k, rowConditions, colConditions)));
    }
}
