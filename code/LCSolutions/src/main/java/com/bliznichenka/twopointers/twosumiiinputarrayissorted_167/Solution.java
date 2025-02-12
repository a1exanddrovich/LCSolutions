package com.bliznichenka.twopointers.twosumiiinputarrayissorted_167;

public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int l = 0;
        int r = numbers.length - 1;

        while (l < r) {
            int curSum = numbers[l] + numbers[r];
            if (curSum < target) {
                l++;
            } else if (curSum > target) {
                r--;
            } else {
                return new int[] {l + 1, r + 1};
            }
        }

        return null;
    }
}
