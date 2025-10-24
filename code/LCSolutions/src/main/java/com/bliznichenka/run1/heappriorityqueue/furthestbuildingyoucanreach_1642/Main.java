package com.bliznichenka.run1.heappriorityqueue.furthestbuildingyoucanreach_1642;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();

        int[] heights = {4, 2, 7, 6, 9, 14, 12};
        int bricks = 5;
        int ladders = 1;
        System.out.println(s.furthestBuilding(heights, bricks, ladders));
    }
}
