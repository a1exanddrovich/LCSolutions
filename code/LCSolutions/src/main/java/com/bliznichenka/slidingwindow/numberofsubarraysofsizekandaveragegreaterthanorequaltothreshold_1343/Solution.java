package com.bliznichenka.slidingwindow.numberofsubarraysofsizekandaveragegreaterthanorequaltothreshold_1343;

public class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int windowSum = 0;
        int result = 0;
        int l = 0;
        int r = 0;

        while (r < arr.length) {
            windowSum += arr[r];
            if (r - l + 1 > k) {
                windowSum -= arr[l];
                l++;
            }
            if (r - l + 1 == k && (windowSum / k) >= threshold) {
                result++;
            }
            r++;
        }

        return result;
    }
}
