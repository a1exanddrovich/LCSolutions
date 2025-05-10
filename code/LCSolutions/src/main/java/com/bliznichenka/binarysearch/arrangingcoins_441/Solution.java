package com.bliznichenka.binarysearch.arrangingcoins_441;

public class Solution {
    public int arrangeCoins(int n) {
        int l = 1;
        int r = n;
        int res = 0;

        while (l <= r) {
            int m = l + (r - l) / 2;
            double cubesRequired = ((double) m / 2) * (m + 1);
            if (cubesRequired > n) {
                r = m - 1;
            } else {
                res = Math.max(res, m);
                l = m + 1;
            }
        }

        return res;
    }
}
