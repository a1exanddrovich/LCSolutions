package com.bliznichenka.arraysandhashing.findpivotindex_724;

public class Solution {
    public int pivotIndex(int[] nums) {
        int sum = 0;
        for (int n : nums) {
            sum += n;
        }

        int prefix = 0;
        for (int i = 0; i < nums.length; i++) {
            int rightPart = sum - prefix - nums[i];
            if (prefix == rightPart) {
                return i;
            }
            prefix += nums[i];
        }

        return -1;
    }
}
