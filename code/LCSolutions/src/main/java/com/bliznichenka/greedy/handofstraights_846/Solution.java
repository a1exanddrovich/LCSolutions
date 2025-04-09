package com.bliznichenka.greedy.handofstraights_846;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0) {
            return false;
        }

        Queue<Integer> minHeap = new PriorityQueue<>();
        Map<Integer, Integer> counter = new HashMap<>();
        for (int n : hand) {
            counter.put(n, counter.getOrDefault(n, 0) + 1);
        }
        minHeap.addAll(counter.keySet());

        while (!minHeap.isEmpty()) {
            int minVal = minHeap.peek();
            for (int i = minVal; i < minVal + groupSize; i++) {
                if (!counter.containsKey(i)) {
                    return false;
                }
                counter.put(i, counter.get(i) - 1);
                if (counter.get(i) == 0) {
                    if (minHeap.peek() != i) {
                        return false;
                    }
                    minHeap.poll();
                    counter.remove(i);
                }
            }
        }

        return true;
    }
}
