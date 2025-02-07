package com.bliznichenka.arraysandhashing.rangesumquery2dimmutable_304;

public class NumMatrix {
    private final int[][] prefix;

    public NumMatrix(int[][] matrix) {
        prefix = new int[matrix.length + 1][matrix[0].length + 1];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                prefix[i + 1][j + 1] =
                        matrix[i][j]
                                + prefix[i + 1 - 1][j + 1]
                                + prefix[i + 1][j + 1 - 1]
                                - prefix[i + 1 - 1][j + 1 - 1];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return prefix[row2 + 1][col2 + 1]
                - prefix[row1 - 1 + 1][col2 + 1]
                - prefix[row2 + 1][col1 - 1 + 1]
                + prefix[row1 - 1 + 1][col1 - 1 + 1];
    }
}
