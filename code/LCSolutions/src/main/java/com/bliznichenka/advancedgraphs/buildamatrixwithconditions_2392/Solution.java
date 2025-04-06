package com.bliznichenka.advancedgraphs.buildamatrixwithconditions_2392;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Solution {
    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
        Map<Integer, List<Integer>> rows = new HashMap<>();
        for (int i = 1; i <= k; i++) {
            rows.put(i, new ArrayList<>());
        }
        for (int[] condition : rowConditions) {
            rows.get(condition[1]).add(condition[0]);
        }
        List<Integer> rowsOrder = new ArrayList<>();
        Set<Integer> rowsVisited = new HashSet<>();
        for (int i = 1; i <= k; i++) {
            if (!dfs(rows, i, rowsOrder, rowsVisited, new HashSet<>())) {
                return new int[][] {};
            }
        }
        Map<Integer, List<Integer>> cols = new HashMap<>();
        for (int i = 1; i <= k; i++) {
            cols.put(i, new ArrayList<>());
        }
        for (int[] condition : colConditions) {
            cols.get(condition[1]).add(condition[0]);
        }
        List<Integer> colsOrder = new ArrayList<>();
        Set<Integer> colsVisited = new HashSet<>();
        for (int i = 1; i <= k; i++) {
            if (!dfs(cols, i, colsOrder, colsVisited, new HashSet<>())) {
                return new int[][] {};
            }
        }

        // [node -> (row, col)]
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 1; i <= k; i++) {
            map.put(i, new ArrayList<>());
        }
        for (int i = 0; i < k; i++) {
            map.get(rowsOrder.get(i)).add(i);
        }
        for (int i = 0; i < k; i++) {
            map.get(colsOrder.get(i)).add(i);
        }

        int[][] matrix = new int[k][];
        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = new int[k];
        }

        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            List<Integer> coordinates = entry.getValue();
            int row = coordinates.get(0);
            int col = coordinates.get(1);
            matrix[row][col] = entry.getKey();
        }

        return matrix;
    }

    private static boolean dfs(
            Map<Integer, List<Integer>> adjacencyList,
            int node,
            List<Integer> result,
            Set<Integer> visited,
            Set<Integer> pathVisited
    ) {
        if (visited.contains(node)) {
            return true;
        }
        if (pathVisited.contains(node)) {
            return false;
        }

        pathVisited.add(node);
        for (int nextNode : adjacencyList.get(node)) {
            if (!dfs(adjacencyList, nextNode, result, visited, pathVisited)) {
                return false;
            }
        }

        pathVisited.remove(node);
        visited.add(node);
        result.add(node);
        return true;
    }
}
