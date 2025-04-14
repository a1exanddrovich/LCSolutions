package com.bliznichenka.mathandgeometry.transposematrix_867;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[][] matrix = {{0, 1, 5}, {1, 2, 5}, {0, 3, 2}};
        System.out.println(Arrays.deepToString(solution.transpose(matrix)));
    }
}
