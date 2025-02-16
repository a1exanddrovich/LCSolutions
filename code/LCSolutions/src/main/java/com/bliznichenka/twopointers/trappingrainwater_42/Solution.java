package com.bliznichenka.twopointers.trappingrainwater_42;

public class Solution {
    public int trap(int[] height) {
        int result = 0;

        int l = 0;
        int r = height.length - 1;
        int leftMax = height[l];
        int rightMax = height[r];

        while (l < r) {
            if (leftMax <= rightMax) {
                int toAdd = leftMax - height[l];

                if (toAdd > 0) {
                    result += toAdd;
                }
                l++;
                leftMax = Math.max(leftMax, height[l]);
            } else {
                int toAdd = rightMax - height[r];

                if (toAdd > 0) {
                    result += toAdd;
                }
                r--;
                rightMax = Math.max(rightMax, height[r]);
            }
        }

        return result;
    }
}
