package com.bliznichenka.binarysearch.kokoeatingbananas_875;

public class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1;
        int r = 0;
        for (int pile : piles) {
            r = Math.max(r, pile);
        }

        int min = r;
        while (l <= r) {
            int m = l + (r - l) / 2;
            int minHours = 0;
            for (int pile : piles) {
                minHours += Math.ceil((double) pile / m);
            }

            if (minHours > h) {
                l = m + 1;
            } else {
                min = m;
                r = m - 1;
            }
        }

        return min;
    }
}
