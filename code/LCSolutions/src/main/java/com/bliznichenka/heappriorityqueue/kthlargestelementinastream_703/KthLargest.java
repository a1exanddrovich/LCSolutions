package com.bliznichenka.heappriorityqueue.kthlargestelementinastream_703;

import java.util.PriorityQueue;
import java.util.Queue;

public class KthLargest {
    private final Queue<Integer> minHeap = new PriorityQueue<>();
    private final int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;

        for (int n : nums) {
            minHeap.add(n);
        }
        while (minHeap.size() > k) {
            minHeap.poll();
        }
    }

    public int add(int val) {
        minHeap.add(val);
        if (minHeap.size() > k) {
            minHeap.poll();
        }
        return minHeap.peek();
    }
}
