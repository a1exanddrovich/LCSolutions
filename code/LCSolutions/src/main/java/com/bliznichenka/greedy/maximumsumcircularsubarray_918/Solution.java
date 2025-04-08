package com.bliznichenka.greedy.maximumsumcircularsubarray_918;

public class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int min = nums[0];
        int max = nums[0];
        int curMin = 0;
        int curMax = 0;
        int totalSum = 0;

        for (int n : nums) {
            curMax = Math.max(n, curMax + n);
            curMin = Math.min(n, curMin + n);

            max = Math.max(max, curMax);
            min = Math.min(min, curMin);

            totalSum += n;
        }

        if (max < 0) {
            return max;
        }
        return Math.max(max, totalSum - min);
    }
}
