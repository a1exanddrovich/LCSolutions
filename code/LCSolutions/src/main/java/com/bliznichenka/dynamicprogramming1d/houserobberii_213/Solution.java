package com.bliznichenka.dynamicprogramming1d.houserobberii_213;

public class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        int includeFirst = helper(nums, 0, nums.length - 2);
        int includeLast = helper(nums, 1, nums.length - 1);

        return Math.max(includeFirst, includeLast);
    }

    private static int helper(int[] nums, int start, int end) {
        int one = nums[end];
        int two = 0;

        for (int i = end - 1; i >= start; i--) {
            int temp = Math.max(nums[i] + two, one);
            two = one;
            one = temp;
        }

        return one;
    }
}
