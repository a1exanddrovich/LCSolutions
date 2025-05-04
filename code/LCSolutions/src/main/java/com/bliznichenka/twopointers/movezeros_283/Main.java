package com.bliznichenka.twopointers.movezeros_283;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] arr = {10, 2, 5, 0, 6};
        s.moveZeroes(arr);
        System.out.println(Arrays.toString(arr));
    }
}
