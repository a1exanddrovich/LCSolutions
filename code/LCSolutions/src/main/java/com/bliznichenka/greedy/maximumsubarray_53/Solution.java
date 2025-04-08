package com.bliznichenka.greedy.maximumsubarray_53;

public class Solution {
    public int maxSubArray(int[] nums) {
        int curSum = 0;
        int max = nums[0];

        for (int n : nums) {
            if (curSum < 0) {
                curSum = 0;
            }
            curSum += n;
            max = Math.max(max, curSum);
        }

        return max;
    }
}
