package com.bliznichenka.heappriorityqueue.singlethreadedcpu_1834;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {
    public int[] getOrder(int[][] tasks) {
        // [index, enqueueTime, processingTime]
        Queue<List<Integer>> availableTimeMinHeap = new PriorityQueue<>(
                Comparator.comparingInt(l -> l.get(1))
        );
        for (int i = 0; i < tasks.length; i++) {
            availableTimeMinHeap.add(List.of(i, tasks[i][0], tasks[i][1]));
        }

        // [index, processingTime]
        Queue<List<Integer>> processingTimeMinHeap = new PriorityQueue<>(
                (l1, l2) -> {
                    if (l1.get(1).equals(l2.get(1))) {
                        return l1.get(0) - l2.get(0);
                    }
                    return l1.get(1) - l2.get(1);
                }
        );

        int resultIndex = 0;
        int[] result = new int[tasks.length];
        int time = availableTimeMinHeap.peek().get(1);
        while (!availableTimeMinHeap.isEmpty() || !processingTimeMinHeap.isEmpty()) {
            while (!availableTimeMinHeap.isEmpty() && availableTimeMinHeap.peek().get(1) <= time) {
                List<Integer> polled = availableTimeMinHeap.poll();
                processingTimeMinHeap.add(List.of(polled.get(0), polled.get(2)));
            }

            if (!processingTimeMinHeap.isEmpty()) {
                List<Integer> polled = processingTimeMinHeap.poll();
                time += polled.get(1);
                result[resultIndex] = polled.get(0);
                resultIndex++;
            } else {
                time = availableTimeMinHeap.peek().get(1);
            }
        }

        return result;
    }
}
