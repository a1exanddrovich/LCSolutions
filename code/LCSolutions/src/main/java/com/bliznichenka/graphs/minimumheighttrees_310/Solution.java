package com.bliznichenka.graphs.minimumheighttrees_310;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) {
            return List.of(0);
        }

        Map<Integer, List<Integer>> adjacencyList = new HashMap<>();

        for (int i = 0; i < n; i++) {
            adjacencyList.put(i, new ArrayList<>());
        }

        for (int[] edge : edges) {
            adjacencyList.get(edge[0]).add(edge[1]);
            adjacencyList.get(edge[1]).add(edge[0]);
        }

        Map<Integer, Integer> edgeCounts = new HashMap<>();
        Deque<Integer> leaves = new ArrayDeque<>();
        for (Map.Entry<Integer, List<Integer>> entry : adjacencyList.entrySet()) {
            int node = entry.getKey();
            List<Integer> nextNodes = entry.getValue();
            if (nextNodes.size() == 1) {
                leaves.addFirst(node);
            }
            edgeCounts.put(node, nextNodes.size());
        }

        while (!leaves.isEmpty()) {
            if (n <= 2) {
                return new ArrayList<>(leaves);
            }
            int len = leaves.size();
            for (int i = 0; i < len; i++) {
                int node = leaves.pollLast();
                n--;
                for (int nextNode : adjacencyList.get(node)) {
                    edgeCounts.put(nextNode, edgeCounts.get(nextNode) - 1);
                    if (edgeCounts.get(nextNode) == 1) {
                        leaves.addFirst(nextNode);
                    }
                }

            }
        }

        // never executes
        return List.of();
    }
}
