package com.bliznichenka.graphs.graphvalidtree_261;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Solution {
    public boolean validTree(int n, int[][] edges) {
        Map<Integer, List<Integer>> adjacencyList = new HashMap<>();

        for (int i = 0; i < n; i++) {
            adjacencyList.put(i, new ArrayList<>());
        }

        for (int[] edge : edges) {
            adjacencyList.get(edge[0]).add(edge[1]);
            adjacencyList.get(edge[1]).add(edge[0]);
        }

        Set<Integer> visited = new HashSet<>();
        return dfs(adjacencyList, 0, -1, visited) && visited.size() == n;
    }

    private static boolean dfs(
            Map<Integer, List<Integer>> adjacencyList,
            int node,
            int prevNode,
            Set<Integer> visited
    ) {
        if (visited.contains(node)) {
            return false;
        }

        visited.add(node);
        for (int nextNode : adjacencyList.get(node)) {
            if (nextNode == prevNode) {
                continue;
            }
            if (!dfs(adjacencyList, nextNode, node, visited)) {
                return false;
            }
        }

        return true;
    }
}
