package com.bliznichenka.backtracking.combinationsumii_40;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();

        int[] nums = {1, 2, 5, 1};
        int target = 7;
        System.out.println(s.combinationSum2(nums, target));
    }
}
