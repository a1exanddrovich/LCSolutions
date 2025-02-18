package com.bliznichenka.slidingwindow.minimumsizesubarraysum_209;

public class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int min = Integer.MAX_VALUE;

        int windowSum = 0;
        int l = 0;
        for (int r = 0; r < nums.length; r++) {
            windowSum += nums[r];

            while (windowSum >= target) {
                min = Math.min(min, r - l + 1);
                windowSum -= nums[l];
                l++;
            }
        }

        return min == Integer.MAX_VALUE ? 0 : min;
    }
}
