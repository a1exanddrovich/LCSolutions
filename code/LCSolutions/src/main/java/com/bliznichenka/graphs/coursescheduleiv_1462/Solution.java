package com.bliznichenka.graphs.coursescheduleiv_1462;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Solution {
    public List<Boolean> checkIfPrerequisite(
            int numCourses,
            int[][] prerequisites,
            int[][] queries
    ) {
        Map<Integer, List<Integer>> adjacencyList = new HashMap<>();

        for (int i = 0; i < numCourses; i++) {
            adjacencyList.put(i, new ArrayList<>());
        }

        for (int[] prereq : prerequisites) {
            adjacencyList.get(prereq[1]).add(prereq[0]);
        }

        Map<Integer, Set<Integer>> prereqMap = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            dfs(adjacencyList, prereqMap, i);
        }

        List<Boolean> answer = new ArrayList<>();
        for (int[] query : queries) {
            answer.add(prereqMap.get(query[1]).contains(query[0]));
        }
        return answer;
    }

    private static Set<Integer> dfs(
            Map<Integer, List<Integer>> adjacencyList,
            Map<Integer, Set<Integer>> prereqMap,
            int course
    ) {
        if (!prereqMap.containsKey(course)){
            Set<Integer> resultSet = new HashSet<>();
            for (int nextCourse : adjacencyList.get(course)) {
                resultSet.add(nextCourse);
                resultSet.addAll(dfs(adjacencyList, prereqMap, nextCourse));
            }

            prereqMap.put(course, resultSet);
        }

        return prereqMap.get(course);
    }
}
