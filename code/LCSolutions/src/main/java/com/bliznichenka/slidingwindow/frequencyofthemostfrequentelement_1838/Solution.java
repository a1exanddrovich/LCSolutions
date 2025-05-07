package com.bliznichenka.slidingwindow.frequencyofthemostfrequentelement_1838;

import java.util.Arrays;

public class Solution {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);

        int result = 1;
        int l = 0;
        int r = 0;
        long totalWindow = 0;
        while (r < nums.length) {
            totalWindow += nums[r];
            while ((long) nums[r] * (r - l + 1) > totalWindow + k) {
                totalWindow -= nums[l];
                l++;
            }
            result = Math.max(result, r - l + 1);
            r++;
        }

        return result;
    }
}
