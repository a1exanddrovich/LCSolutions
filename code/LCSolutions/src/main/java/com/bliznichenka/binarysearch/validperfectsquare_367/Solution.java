package com.bliznichenka.binarysearch.validperfectsquare_367;

public class Solution {
    public boolean isPerfectSquare(int num) {
        int l = 1;
        int r = num;

        while (l <= r) {
            long m = l + (r - l) / 2;
            long squared = m * m;

            if (squared > num) {
                r = (int) m - 1;
            } else if (squared < num) {
                l = (int) m + 1;
            } else {
                return true;
            }
        }

        return false;
    }
}
