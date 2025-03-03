package com.bliznichenka.binarysearch.splitarraylargestsum_410;

public class Solution {
    public int splitArray(int[] nums, int k) {
        int l = 0;
        int r = 0;
        for (int n : nums) {
            l = Math.max(l, n);
            r += n;
        }

        int res = r;
        while (l <= r) {
            int m = l + (r - l) / 2;

            // try to split the array
            int parts = 1;
            int curSum = 0;
            for (int n : nums) {
                if (curSum + n > m) {
                    parts++;
                    curSum = 0;
                }
                curSum += n;
            }

            // if we could, try to find the smaller result
            if (parts <= k) {
                res = m;
                r = m - 1;
            } else {
                l = m + 1;
            }

        }

        return res;
    }
}
