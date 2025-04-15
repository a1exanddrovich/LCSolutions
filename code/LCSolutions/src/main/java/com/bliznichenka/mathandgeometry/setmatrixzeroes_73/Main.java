package com.bliznichenka.mathandgeometry.setmatrixzeroes_73;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[][] matrix = {{1, 1, 1}, {1, 1, 1}, {0, 1, 1}};
        solution.setZeroes(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }
}
