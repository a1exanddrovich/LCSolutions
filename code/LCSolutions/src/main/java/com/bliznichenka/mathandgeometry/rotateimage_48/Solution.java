package com.bliznichenka.mathandgeometry.rotateimage_48;

public class Solution {
    public void rotate(int[][] matrix) {
        int left = 0;
        int right = matrix.length - 1;

        while (left < right) {
            int top = left;
            int bottom = right;
            for (int shift = 0; shift < (right - left); shift++) {
                int topLeft = matrix[top][left + shift];

                matrix[top][left + shift] = matrix[bottom - shift][left];

                matrix[bottom - shift][left] = matrix[bottom][right - shift];

                matrix[bottom][right - shift] = matrix[top + shift][right];

                matrix[top + shift][right] = topLeft;
            }
            left++;
            right--;
        }
    }
}
