package com.bliznichenka.binarysearch.searcha2dmatrix_74;

public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int t = 0;
        int b = rows - 1;
        while (t <= b) {
            int m = t + (b - t) / 2;

            if (target > matrix[m][cols - 1]) {
                t = m + 1;
            } else if (target < matrix[m][0]) {
                b = m - 1;
            } else {
                break;
            }
        }

        if (t > b) {
            return false;
        }

        int l = 0;
        int r = cols - 1;
        int row = (t + b) / 2;
        while (l <= r) {
            int m = l + (r - l) / 2;

            if (matrix[row][m] < target) {
                l = m + 1;
            } else if (matrix[row][m] > target) {
                r = m - 1;
            } else {
                return true;
            }
        }

        return false;
    }
}
