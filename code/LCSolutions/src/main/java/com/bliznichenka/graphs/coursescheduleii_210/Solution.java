package com.bliznichenka.graphs.coursescheduleii_210;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> adjacencyList = new HashMap<>();

        for (int i = 0; i < numCourses; i++) {
            adjacencyList.put(i, new ArrayList<>());
        }

        for (int[] prereq : prerequisites) {
            adjacencyList.get(prereq[0]).add(prereq[1]);
        }

        List<Integer> result = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();
        for (int i = 0; i < numCourses; i++) {
            if (!dfs(adjacencyList, i, result, visited, new HashSet<>())) {
                return new int[]{};
            }
        }

        return result.stream().mapToInt(i -> i).toArray();
    }

    private static boolean dfs(
            Map<Integer, List<Integer>> adjacencyList,
            int course,
            List<Integer> resultPath,
            Set<Integer> visited,
            Set<Integer> pathVisited
    ) {
        if (pathVisited.contains(course)) {
            return false;
        }
        if (visited.contains(course)) {
            return true;
        }

        pathVisited.add(course);
        for (int nextCourse : adjacencyList.get(course)) {
            if (!dfs(adjacencyList, nextCourse, resultPath, visited, pathVisited)) {
                return false;
            }
        }

        pathVisited.remove(course);
        resultPath.add(course);
        visited.add(course);
        return true;
    }
}
