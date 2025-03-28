package com.bliznichenka.graphs.evaluatedivision_399;

import javafx.util.Pair;

import java.util.*;

public class Solution {
    public double[] calcEquation(
            List<List<String>> equations,
            double[] values,
            List<List<String>> queries) {
        Map<String, Map<String, Double>> adjacencyList = new HashMap<>();

        for (int i = 0; i < equations.size(); i++) {
            String first = equations.get(i).get(0);
            String second = equations.get(i).get(1);

            if (!adjacencyList.containsKey(first)) {
                adjacencyList.put(first, new HashMap<>());
            }
            if (!adjacencyList.containsKey(second)) {
                adjacencyList.put(second, new HashMap<>());
            }

            adjacencyList.get(first).put(second, values[i]);
            adjacencyList.get(second).put(first, 1.0 / values[i]);
        }

        double[] res = new double[queries.size()];
        for (int i = 0; i < res.length; i++) {
            String first = queries.get(i).get(0);
            String second = queries.get(i).get(1);
            res[i] = bfs(adjacencyList, first, second);
        }
        return res;
    }

    private static double bfs(
            Map<String, Map<String, Double>> adjacencyList,
            String first,
            String second
    ) {
        if (!adjacencyList.containsKey(first) || !adjacencyList.containsKey(second)) {
            return -1.0;
        }

        Deque<Pair<String, Double>> deque = new ArrayDeque<>();
        Set<String> visited = new HashSet<>();

        deque.addFirst(new Pair<>(first, 1.0));
        visited.add(first);

        while (!deque.isEmpty()) {
            Pair<String, Double> polled = deque.pollLast();
            String variable = polled.getKey();
            double val = polled.getValue();

            if (variable.equals(second)) {
                return val;
            }

            for (Map.Entry<String, Double> next : adjacencyList.get(variable).entrySet()) {
                if (visited.contains(next.getKey())) {
                    continue;
                }
                visited.add(next.getKey());
                deque.add(new Pair<>(next.getKey(), val * next.getValue()));
            }
        }

        return -1.0;
    }
}
