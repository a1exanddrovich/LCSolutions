package com.bliznichenka.twopointers.rotatearray_189;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;
        solution.rotate(arr, k);
        System.out.println(Arrays.toString(arr));
    }
}
