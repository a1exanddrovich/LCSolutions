package com.bliznichenka.advancedgraphs.networkdelaytime_743;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        // [node -> [(node, weight)]]
        Map<Integer, List<List<Integer>>> adjacencyList = new HashMap<>();

        for (int i = 1; i <= n; i++) {
            adjacencyList.put(i, new ArrayList<>());
        }
        for (int[] time : times) {
            adjacencyList.get(time[0]).add(List.of(time[1], time[2]));
        }

        // [node, totalWeight]
        Queue<List<Integer>> minHeap = new PriorityQueue<>(
                Comparator.comparingInt(l -> l.get(1))
        );

        // [node]
        Set<Integer> visited = new HashSet<>();

        int time = 0;
        minHeap.add(List.of(k, 0));

        while (!minHeap.isEmpty()) {
            List<Integer> polled = minHeap.poll();
            int node = polled.get(0);
            int weight = polled.get(1);

            if (visited.contains(node)) {
                continue;
            }
            visited.add(node);
            time = weight;

            for (List<Integer> neighbor : adjacencyList.get(node)) {
                int nextNode = neighbor.get(0);
                int nextWeight = neighbor.get(1);
                if (!visited.contains(nextNode)) {
                    minHeap.add(List.of(nextNode, weight + nextWeight));
                }
            }
        }

        return visited.size() == n ? time : -1;
    }
}
