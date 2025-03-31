package com.bliznichenka.heappriorityqueue.findmedianfromdatastream_295;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class MedianFinder {
    private final Queue<Integer> large = new PriorityQueue<>();
    private final Queue<Integer> small = new PriorityQueue<>(Comparator.reverseOrder());

    public void addNum(int num) {
        small.add(num);

        if (!small.isEmpty()
                && !large.isEmpty()
                && small.peek() > large.peek()) {
            int maxVal = small.poll();
            large.add(maxVal);
        }

        if (small.size() > large.size() + 1) {
            int maxVal = small.poll();
            large.add(maxVal);
        }

        if (large.size() > small.size() + 1) {
            int minVal = large.poll();
            small.add(minVal);
        }
    }

    public double findMedian() {
        if (small.size() > large.size()) {
            return small.peek();
        } else if (large.size() > small.size()) {
            return large.peek();
        } else {
            return ((double) small.peek() + (double) large.peek() ) / 2;
        }
    }
}
