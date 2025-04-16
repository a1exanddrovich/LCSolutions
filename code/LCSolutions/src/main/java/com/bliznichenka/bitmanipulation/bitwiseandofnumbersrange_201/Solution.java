package com.bliznichenka.bitmanipulation.bitwiseandofnumbersrange_201;

public class Solution {
    public int rangeBitwiseAnd(int left, int right) {
        int res = 0;

        for (int i = 0; i < 32; i++) {
            int bit = (left >> i) & 1;
            if (bit == 0) {
                continue;
            }
            int remainder = left % (int) Math.pow(2, i);
            int diff = (int) Math.pow(2, i) - remainder;
            if (right - left < diff) {
                res = res | (bit << i);
            }
        }

        return res;
    }
}
