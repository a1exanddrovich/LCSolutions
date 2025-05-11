package com.bliznichenka.binarysearch.singleelementinasortedarray_540;

public class Solution {
    public int singleNonDuplicate(int[] nums) {
        int l = 0;
        int r = nums.length - 1;

        while (l < r) {
            int m = l + (r - l) / 2;

            if (m - 1 >= 0 && nums[m] == nums[m - 1]) {
                if ((r - m) % 2 == 0) {
                    r = m - 2;
                } else {
                    l = m + 1;
                }
            } else if (m + 1 < nums.length && nums[m] == nums[m + 1]) {
                if ((m - l) % 2 == 0) {
                    l = m + 2;
                } else {
                    r = m - 1;
                }
            } else {
                return nums[m];
            }
        }

        return nums[l];
    }
}
