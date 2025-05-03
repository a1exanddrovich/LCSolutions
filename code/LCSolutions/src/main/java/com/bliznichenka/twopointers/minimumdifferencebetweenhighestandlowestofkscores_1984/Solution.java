package com.bliznichenka.twopointers.minimumdifferencebetweenhighestandlowestofkscores_1984;

import java.util.Arrays;

public class Solution {
    public int minimumDifference(int[] nums, int k) {
        Arrays.sort(nums);
        int diff = Integer.MAX_VALUE;
        for (int i = k - 1; i < nums.length; i++) {
            diff = Math.min(diff, nums[i] - nums[i - k + 1]);
        }
        return diff;
    }
}
