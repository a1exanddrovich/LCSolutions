package com.bliznichenka.dynamicprogramming1d.longestincreasingsubsequence_300;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();

        int[] nums = {0, 1, 0, 3, 2, 3};
        System.out.println(s.lengthOfLIS(nums));
    }
}
