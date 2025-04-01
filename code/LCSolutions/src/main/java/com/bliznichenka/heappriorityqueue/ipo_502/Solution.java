package com.bliznichenka.heappriorityqueue.ipo_502;

import javafx.util.Pair;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        // [profit, capital]
        Queue<Pair<Integer, Integer>> minHeap = new PriorityQueue<>(
                Comparator.comparingInt(Pair::getValue)
        );
        // [profit, capital]
        Queue<Pair<Integer, Integer>> maxHeap = new PriorityQueue<>(
                (p1, p2) -> p2.getKey() - p1.getKey()
        );

        for (int i = 0; i < profits.length; i++) {
            minHeap.add(new Pair<>(profits[i], capital[i]));
        }

        for (int i = 0; i < k; i++) {
            while (!minHeap.isEmpty() && minHeap.peek().getValue() <= w) {
                maxHeap.add(minHeap.poll());
            }

            if (maxHeap.isEmpty()) {
                break;
            }
            w += maxHeap.poll().getKey();
        }

        return w;
    }
}
