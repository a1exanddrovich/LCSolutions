package com.bliznichenka.greedy.jumpgame_55;

public class Solution {
    public boolean canJump(int[] nums) {
        int goal = nums.length - 1;

        int cur = nums.length - 2;
        while (cur >= 0) {
            int minJumps = goal - cur;
            if (nums[cur] >= minJumps) {
                goal = cur;
            }
            cur--;
        }

        return goal == 0;
    }
}
