package com.bliznichenka.heappriorityqueue.carpooling_1094;

import java.util.*;

public class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        Arrays.sort(trips, Comparator.comparingInt(trip -> trip[1]));

        // [people, to]
        Queue<List<Integer>> minHeap = new PriorityQueue<>(
                Comparator.comparingInt(l -> l.get(1))
        );

        for (int[] trip : trips) {
            int people = trip[0];
            int from = trip[1];
            int to = trip[2];

            while (!minHeap.isEmpty() && minHeap.peek().get(1) <= from) {
                capacity += minHeap.poll().get(0);
            }

            if (people > capacity) {
                return false;
            }

            minHeap.add(List.of(people, to));
            capacity -= people;
        }

        return true;
    }
}
