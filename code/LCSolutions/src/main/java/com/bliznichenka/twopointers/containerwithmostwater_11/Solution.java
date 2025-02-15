package com.bliznichenka.twopointers.containerwithmostwater_11;

public class Solution {
    public int maxArea(int[] height) {
        int maxArea = 0;

        int l = 0;
        int r = height.length - 1;

        while (l < r) {
            int curArea = (r - l) * Math.min(height[l], height[r]);
            maxArea = Math.max(maxArea, curArea);

            if (height[r] < height[l]) {
                r--;
            } else {
                l++;
            }
        }

        return maxArea;
    }
}
