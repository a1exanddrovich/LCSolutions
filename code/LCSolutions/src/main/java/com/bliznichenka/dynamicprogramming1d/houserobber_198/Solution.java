package com.bliznichenka.dynamicprogramming1d.houserobber_198;

public class Solution {
    public int rob(int[] nums) {
        int two = 0;
        int one = nums[nums.length - 1];

        for (int i = nums.length - 2; i >= 0; i--) {
            int temp = Math.max(nums[i] + two, one);
            two = one;
            one = temp;
        }

        return one;
    }
}
