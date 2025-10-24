package com.bliznichenka.run1.heappriorityqueue.leastnumberofuniqueintegersafterkremovals_1481;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer, Integer> counter = new HashMap<>();
        for (int n : arr) {
            counter.put(n, counter.getOrDefault(n, 0) + 1);
        }

        Queue<Integer> minHeap = new PriorityQueue<>();
        for (int count : counter.values()) {
            minHeap.add(count);
        }

        while (k > 0) {
            int polled = minHeap.poll();
            if (k >= polled) {
                k -= polled;
            } else {
                minHeap.add(polled - k);
                k -= polled;
            }
        }

        return minHeap.size();
    }

    // Counting approach
//    public int findLeastNumOfUniqueInts(int[] arr, int k) {
//        Map<Integer, Integer> counter = new HashMap<>();
//        for (int n : arr) {
//            counter.put(n, counter.getOrDefault(n, 0) + 1);
//        }
//
//        int[] counts = new int[arr.length + 1];
//        for (int count : counter.values()) {
//            counts[count]++;
//        }
//
//        int res = counter.size();
//
//        for (int freq = 0; freq < counts.length; freq++) {
//            int toRemove = counts[freq];
//            if (k >= freq * toRemove) {
//                k -= (freq * toRemove);
//                res -= toRemove;
//            } else {
//                int canDelete = k / freq;
//                res -= canDelete;
//                break;
//            }
//        }
//
//        return res;
//    }
}
