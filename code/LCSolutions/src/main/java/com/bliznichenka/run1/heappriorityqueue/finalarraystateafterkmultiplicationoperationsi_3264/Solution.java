package com.bliznichenka.run1.heappriorityqueue.finalarraystateafterkmultiplicationoperationsi_3264;

import javafx.util.Pair;

import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        // [value, index]
        Queue<Pair<Integer, Integer>> minHeap = new PriorityQueue<>(
                (a, b) -> {
                    if (a.getKey().equals(b.getKey())) {
                        return a.getValue() - b.getValue();
                    }
                    return a.getKey() - b.getKey();
                }
        );

        for (int i = 0; i < nums.length; i++) {
            minHeap.add(new Pair<>(nums[i], i));
        }

        for (int i = 0; i < k; i++) {
            Pair<Integer, Integer> polled = minHeap.poll();
            minHeap.add(new Pair<>(polled.getKey() * multiplier, polled.getValue()));
        }

        while (!minHeap.isEmpty()) {
            Pair<Integer, Integer> polled = minHeap.poll();
            nums[polled.getValue()] = polled.getKey();
        }

        return nums;
    }
}
