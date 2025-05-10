package com.bliznichenka.binarysearch.squaresofsortedarray_977;

public class Solution {
    public int[] sortedSquares(int[] nums) {
        int[] res = new int[nums.length];

        int i = 0;
        int j = nums.length - 1;
        int k = nums.length - 1;

        while (i <= j) {
            int num1 = nums[i] * nums[i];
            int num2 = nums[j] * nums[j];

            if (num1 > num2) {
                res[k] = num1;
                i++;
            } else {
                res[k] = num2;
                j--;
            }
            k--;
        }

        return res;
    }
}
