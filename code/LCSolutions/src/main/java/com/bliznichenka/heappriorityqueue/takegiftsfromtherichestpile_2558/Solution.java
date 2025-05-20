package com.bliznichenka.heappriorityqueue.takegiftsfromtherichestpile_2558;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {
    public long pickGifts(int[] gifts, int k) {
        Queue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());

        for (int gift : gifts) {
            maxHeap.add(gift);
        }

        for (int i = 0; i < k; i++) {
            double polled = maxHeap.poll();
            maxHeap.add((int) Math.floor(Math.sqrt(polled)));
        }

        long sum = 0;
        while (!maxHeap.isEmpty()) {
            sum += maxHeap.poll();
        }

        return sum;
    }
}
