package com.bliznichenka.linkedlist.findtheduplicatenumber_287;

public class Solution {
    public int findDuplicate(int[] nums) {
        int l = 1;
        int r = nums.length - 1;

        while (l < r) {
            int mid = l + (r - l) / 2;

            int count = 0;
            for (int num : nums) {
                if (mid >= num) {
                    count++;
                }
            }

            if (count > mid) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }

        return l;
    }
}
