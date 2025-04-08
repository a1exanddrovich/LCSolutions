package com.bliznichenka.greedy.jumpgameii_45;

public class Solution {
    public int jump(int[] nums) {
        int level = 0;
        int l = 0;
        int r = 0;

        while (r < nums.length - 1) {
            int maxRight = r;
            int node = l;
            while (node <= r) {
                maxRight = Math.max(maxRight, node + nums[node]);
                node++;
            }

            l = r + 1;
            r = maxRight;
            level++;
        }

        return level;
    }
}
