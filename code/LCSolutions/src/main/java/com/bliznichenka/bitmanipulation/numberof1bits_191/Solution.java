package com.bliznichenka.bitmanipulation.numberof1bits_191;

public class Solution {
    public int hammingWeight(int n) {
        int count = 0;
        while (n > 0) {
            // check the rightmost bit in the binary view of the n
            // if it's 1 -> increment the count
            if ((n & 1) == 1) {
                count++;
            }
            // kinda chop off the rightmost bit as we've already looked at it
            // and need to check the rest of the bits.
            n >>= 1;
        }
        return count;
    }
}
