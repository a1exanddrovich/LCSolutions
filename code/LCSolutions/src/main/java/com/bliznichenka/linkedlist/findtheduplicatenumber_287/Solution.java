package com.bliznichenka.linkedlist.findtheduplicatenumber_287;

public class Solution {
    public int findDuplicate(int[] nums) {
        int slow = 0;
        int fast = 0;

        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        int slow2 = 0;

        while (slow != slow2) {
            slow2 = nums[slow2];
            slow = nums[slow];
        }

        return slow;
    }
}
