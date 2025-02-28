package com.bliznichenka.binarysearch.searcha2dmatrix_74;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] arr = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
        int target = 0;
        System.out.println(s.searchMatrix(arr, target));
    }
}
