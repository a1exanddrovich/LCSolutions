package com.bliznichenka.heappriorityqueue.kclosestpointstoorigin_973;

import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {
    // O(nlogk) for TC and k for MC
    public int[][] kClosest(int[][] points, int k) {
        // comparator that that compares two points by the squared distance. I don't
        // take the square root here.
        Queue<int[]> maxHeap = new PriorityQueue<>(
                (p1, p2) -> (p2[0] * p2[0] + p2[1] * p2[1]) - (p1[0] * p1[0] + p1[1] * p1[1])
        );
        // or else can be like this
//        Queue<int[]> maxHeap = new PriorityQueue<>(
//                (p1, p2) -> Integer.compare(
//                        p2[0] * p2[0] + p2[1] * p2[1],
//                        p1[0] * p1[0] + p1[1] * p1[1]
//                )
//        );

        for (int[] point : points) {
            maxHeap.add(point);
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }

        int[][] result = new int[k][];
        int i = 0;
        while (!maxHeap.isEmpty()) {
            result[i] = maxHeap.poll();
            i++;
        }
        return result;
    }
}
