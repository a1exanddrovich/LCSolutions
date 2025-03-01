package com.bliznichenka.binarysearch.findminimuminrotatedsortedarray_153;

public class Solution {
    public int findMin(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        int min = nums[0];

        while (l <= r) {
            if (nums[l] < nums[r]) {
                min = Math.min(min, nums[l]);
                break;
            }
            int m = l + (r - l) / 2;

            min = Math.min(min, nums[m]);

            if (nums[m] >= nums[l]) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }

        return min;
    }
}
