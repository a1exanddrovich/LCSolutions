package com.bliznichenka.graphs.courseschedule_207;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> adjacencyList = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            adjacencyList.put(i, new ArrayList<>());
        }

        for (int[] prerequisite : prerequisites) {
            adjacencyList.get(prerequisite[0]).add(prerequisite[1]);
        }

        for (int i = 0; i < numCourses; i++) {
            if (!dfs(i, adjacencyList, new HashSet<>())) {
                return false;
            }
        }

        return true;
    }

    private static boolean dfs(
            int i,
            Map<Integer, List<Integer>> adjacencyList,
            Set<Integer> visited
    ) {
        if (adjacencyList.get(i).isEmpty()) {
            return true;
        }
        if (visited.contains(i)) {
            return false;
        }

        visited.add(i);
        for (int nextCourse : adjacencyList.get(i)) {
            if (!dfs(nextCourse, adjacencyList, visited)) {
                return false;
            }
        }

        visited.remove(i);
        adjacencyList.put(i, List.of());
        return true;
    }
}
