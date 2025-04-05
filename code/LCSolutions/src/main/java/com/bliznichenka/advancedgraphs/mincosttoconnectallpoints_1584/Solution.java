package com.bliznichenka.advancedgraphs.mincosttoconnectallpoints_1584;

import java.util.*;

public class Solution {
    public int minCostConnectPoints(int[][] points) {
        // [node -> [(node, weight)]]
        Map<Integer, List<List<Integer>>> adjacencyList = new HashMap<>();

        for (int i = 0; i < points.length; i++) {
            adjacencyList.put(i, new ArrayList<>());
        }
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                adjacencyList.get(i).add(List.of(j, manhattanDistance(points[i], points[j])));
                adjacencyList.get(j).add(List.of(i, manhattanDistance(points[i], points[j])));
            }
        }

        // [node, weight]
        Queue<List<Integer>> minHeap = new PriorityQueue<>(
                Comparator.comparingInt(list -> list.get(1))
        );
        Set<Integer> visited = new HashSet<>();
        int totalWeight = 0;

        minHeap.add(List.of(0, 0));
        while (!minHeap.isEmpty()) {
            List<Integer> polled = minHeap.poll();
            int node = polled.get(0);
            int weight = polled.get(1);

            if (visited.contains(node)) {
                continue;
            }

            visited.add(node);
            totalWeight += weight;

            for (List<Integer> nextData : adjacencyList.get(node)) {
                int nextNode = nextData.get(0);
                int nextWeight = nextData.get(1);
                if (visited.contains(nextNode)) {
                    continue;
                }
                minHeap.add(List.of(nextNode, nextWeight));
            }
        }

        return totalWeight;
    }

    private static int manhattanDistance(int[] point1, int[] point2) {
        return Math.abs(point1[0] - point2[0]) + Math.abs(point1[1] - point2[1]);
    }
}
