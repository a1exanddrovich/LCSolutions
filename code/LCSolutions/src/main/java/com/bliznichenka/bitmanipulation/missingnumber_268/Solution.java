package com.bliznichenka.bitmanipulation.missingnumber_268;

public class Solution {
    public int missingNumber(int[] nums) {
        int rangeSum = (nums.length + 1) * nums.length / 2;

        int arraySum = 0;
        for (int n : nums) {
            arraySum += n;
        }

        return rangeSum - arraySum;
    }
}
