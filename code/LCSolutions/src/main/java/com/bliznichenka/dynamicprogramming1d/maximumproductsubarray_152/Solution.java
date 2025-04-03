package com.bliznichenka.dynamicprogramming1d.maximumproductsubarray_152;

public class Solution {
    public int maxProduct(int[] nums) {
        int curMax = nums[0];
        int curMin = nums[0];
        int max = curMax;

        for (int i = 1; i < nums.length; i++) {
            int prevMax = curMax;
            curMax = Math.max(nums[i], Math.max(nums[i] * prevMax, nums[i] * curMin));
            curMin = Math.min(nums[i], Math.min(nums[i] * prevMax, nums[i] * curMin));
            max = Math.max(max, curMax);
        }

        return max;
    }
}
