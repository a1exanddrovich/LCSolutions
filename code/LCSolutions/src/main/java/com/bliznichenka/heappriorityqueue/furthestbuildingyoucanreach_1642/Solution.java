package com.bliznichenka.heappriorityqueue.furthestbuildingyoucanreach_1642;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        Queue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());

        int i = 0;
        while (i < heights.length - 1 && bricks >= 0) {
            int diff = heights[i + 1] - heights[i];
            if (diff <= 0) {
                i++;
                continue;
            }

            maxHeap.add(diff);
            bricks -= diff;

            if (bricks >= 0) {
                i++;
                continue;
            }

            if (ladders > 0) {
                bricks += maxHeap.poll();
                ladders--;
                i++;
            }
        }

        return i;
    }
}
