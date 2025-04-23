package com.bliznichenka.advancedgraphs.pathwithmaximumprobability_1514;

import javafx.util.Pair;

import java.util.*;

public class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int startNode, int endNode) {
        // node -> list of (probability (weight), neighborNode)
        Map<Integer, List<Pair<Double, Integer>>> adjacencyList = new HashMap<>();

        for (int i = 0; i < n; i++) {
            adjacencyList.put(i, new ArrayList<>());
        }

        for (int i = 0; i < edges.length; i++) {
            int[] edge = edges[i];
            double probability = succProb[i];
            adjacencyList.get(edge[0]).add(new Pair<>(probability, edge[1]));
            adjacencyList.get(edge[1]).add(new Pair<>(probability, edge[0]));
        }

        Set<Integer> visited = new HashSet<>();
        // (currentProbability, node) - the total probability to reach the node
        // this is the reversed double comparator
        Queue<Pair<Double, Integer>> maxHeap = new PriorityQueue<>(
                (o1, o2) -> o2.getKey().compareTo(o1.getKey())
        );

        maxHeap.add(new Pair<>(1.0, startNode));

        while (!maxHeap.isEmpty()) {
            Pair<Double, Integer> polled = maxHeap.poll();
            double probability = polled.getKey();
            int node = polled.getValue();

            visited.add(node);

            if (node == endNode) {
                return probability;
            }

            List<Pair<Double, Integer>> neighbors = adjacencyList.get(node);
            for (Pair<Double, Integer> neighbor : neighbors) {
                if (!visited.contains(neighbor.getValue())) {
                    maxHeap.add(new Pair<>(probability * neighbor.getKey(), neighbor.getValue()));
                }
            }
        }

        return 0.0;
    }
}
