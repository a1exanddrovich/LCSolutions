package com.bliznichenka.binarysearch.firstbadversion_278;


public class Solution {
    public int firstBadVersion(int n) {
        int l = 1;
        int r = n;

        int earliestBadVersion = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (isBadVersion(mid)) {
                r = mid - 1;
                earliestBadVersion = mid;
            } else {
                l = mid + 1;
            }
        }

        return earliestBadVersion;
    }

    private boolean isBadVersion(int n) {
        return n >= 3;
    }
}
