package com.bliznichenka.binarysearch.findpeakelement_162;

public class Solution {
    public int findPeakElement(int[] nums) {
        int l = 0;
        int r = nums.length - 1;

        while (l <= r) {
            int m = l + (r - l) / 2;

            if (m > 0 && nums[m - 1] > nums[m]) {
                r = m - 1;
            } else if (m + 1 < nums.length && nums[m] < nums[m + 1]) {
                l = m + 1;
            } else {
                return m;
            }
        }

        return -1;
    }
}
