package com.bliznichenka.advancedgraphs.sortitemsbygroupsrespectingdependencies_1203;

import java.util.*;

public class Solution {
    public int[] sortItems(int n, int m, int[] group, List<List<Integer>> beforeItems) {
        for (int i = 0; i < n; i++) {
            if (group[i] == -1) {
                group[i] = m;
                m++;
            }
        }

        Map<Integer, List<Integer>> itemAdjacencyList = new HashMap<>();
        Map<Integer, List<Integer>> groupAdjacencyList = new HashMap<>();
        for (int i = 0; i < n; i++) {
            itemAdjacencyList.put(i, new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            groupAdjacencyList.put(i, new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            for (int predecessor : beforeItems.get(i)) {
                itemAdjacencyList.get(i).add(predecessor);
                if (group[i] != group[predecessor]) {
                    groupAdjacencyList.get(group[i]).add(group[predecessor]);
                }
            }
        }

        List<Integer> sortedItems = topologicalSort(itemAdjacencyList, n);
        if (sortedItems.isEmpty()) {
            return new int[]{};
        }

        List<Integer> sortedGroups = topologicalSort(groupAdjacencyList, m);
        if (sortedGroups.isEmpty()) {
            return new int[]{};
        }

        Map<Integer, List<Integer>> grouping = new HashMap<>();
        for (int i = 0; i < m; i++) {
            grouping.put(i, new ArrayList<>());
        }

        for (int item : sortedItems) {
            grouping.get(group[item]).add(item);
        }

        List<Integer> res = new ArrayList<>();
        for (int g : sortedGroups) {
            res.addAll(grouping.get(g));
        }

        return res.stream().mapToInt(Integer::intValue).toArray();
    }

    private static List<Integer> topologicalSort(Map<Integer, List<Integer>> adjacencyList, int n) {
        List<Integer> result = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();

        for (int i = 0; i < n; i++) {
            if (!dfs(adjacencyList, i, visited, new HashSet<>(), result)) {
                return List.of();
            }
        }

        return result;
    }

    private static boolean dfs(
            Map<Integer, List<Integer>> adjacencyList,
            int i,
            Set<Integer> visited,
            Set<Integer> path,
            List<Integer> result) {
        if (visited.contains(i)) {
            return true;
        }
        if (path.contains(i)) {
            return false;
        }

        path.add(i);
        for (int nextItem : adjacencyList.get(i)) {
            if (!dfs(adjacencyList, nextItem, visited, path, result)) {
                return false;
            }
        }
        path.remove(i);

        visited.add(i);
        result.add(i);
        return true;
    }
}
