package com.bliznichenka.binarysearch.sqrtx_69;

public class Solution {
    public int mySqrt(int x) {
        int l = 0;
        int r = x;

        int result = 0;
        while (l <= r) {
            long m = l + (r - l) / 2;
            long sqr = m * m;

            if (sqr > x) {
                r = (int) m - 1;
            } else {
                l = (int) m + 1;
                result = (int) m;
            }
        }

        return result;
    }
}
