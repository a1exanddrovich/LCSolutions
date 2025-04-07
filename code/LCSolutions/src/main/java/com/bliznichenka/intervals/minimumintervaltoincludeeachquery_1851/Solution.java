package com.bliznichenka.intervals.minimumintervaltoincludeeachquery_1851;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        Arrays.sort(intervals, Comparator.comparingInt(i -> i[0]));
        int[] sortedQueries = Arrays.copyOf(queries, queries.length);
        Arrays.sort(sortedQueries);
        // query -> minLen
        Map<Integer, Integer> map = new HashMap<>();
        // [interval length, right value]
        Queue<List<Integer>> minHeap = new PriorityQueue<>(
            (l1, l2) -> {
                if (l1.get(0).equals(l2.get(0))) {
                    return l1.get(1) - l2.get(1);
                }
                return l1.get(0) - l2.get(0);
            }
        );

        int i = 0;
        for (int query : sortedQueries) {
            while (i < intervals.length && intervals[i][0] <= query) {
                int l = intervals[i][0];
                int r = intervals[i][1];
                minHeap.add(List.of(r - l + 1, r));
                i++;
            }

            while (!minHeap.isEmpty() && minHeap.peek().get(1) < query) {
                minHeap.poll();
            }

            if (minHeap.isEmpty()) {
                map.put(query, -1);
            } else {
                map.put(query, minHeap.peek().get(0));
            }
        }

        int[] res = new int[queries.length];
        for (int j = 0; j < res.length; j++) {
            res[j] = map.get(queries[j]);
        }
        return res;
    }
}
