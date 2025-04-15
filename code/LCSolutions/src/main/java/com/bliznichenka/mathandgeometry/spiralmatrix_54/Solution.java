package com.bliznichenka.mathandgeometry.spiralmatrix_54;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();

        int l = 0;
        int r = matrix[0].length;
        int t = 0;
        int b = matrix.length;

        while (l < r && t < b) {
            // add top row
            for (int j = l; j < r; j++) {
                res.add(matrix[t][j]);
            }
            t++;

            // arr right column
            for (int i = t; i < b; i++) {
                res.add(matrix[i][r - 1]);
            }
            r--;

            // if the matrix is a single row or a single column then break
            if (t >= b || l >= r) {
                break;
            }

            // add the bottom row
            for (int j = r - 1; j >= l; j--) {
                res.add(matrix[b - 1][j]);
            }
            b--;

            // add the left column
            for (int i = b - 1; i >= t; i--) {
                res.add(matrix[i][l]);
            }
            l++;
        }

        return res;
    }
}
