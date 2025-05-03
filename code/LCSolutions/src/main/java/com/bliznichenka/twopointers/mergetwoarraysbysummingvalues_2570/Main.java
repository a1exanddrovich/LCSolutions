package com.bliznichenka.twopointers.mergetwoarraysbysummingvalues_2570;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[][] nums1 = {{1, 2}, {2, 3}, {4, 5}};
        int[][] nums2 = {{1, 4}, {3, 2}, {4, 1}};
        System.out.println(Arrays.deepToString(solution.mergeArrays(nums1, nums2)));
    }
}
