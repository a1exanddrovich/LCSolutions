package com.bliznichenka.advancedgraphs.aliendictionary_269;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {
    public String alienOrder(String[] words) {
        Map<Character, Set<Character>> adjacencyList = new HashMap<>();
        for (String word : words) {
            for (char c : word.toCharArray()) {
                if (adjacencyList.containsKey(c)) {
                    continue;
                }
                adjacencyList.put(c, new HashSet<>());
            }
        }

        for (int k = 1; k < words.length; k++) {
            String w1 = words[k - 1];
            String w2 = words[k];

            int i = 0;
            int j = 0;
            while (i < w1.length() && j < w2.length() && w1.charAt(i) == w2.charAt(j)) {
                i++;
                j++;
            }

            if (i < w1.length() && j < w2.length()) {
                adjacencyList.get(w1.charAt(i)).add(w2.charAt(j));
            } else if (i < w1.length()) {
                return "";
            }
        }

        StringBuilder result = new StringBuilder();
        Set<Character> visited = new HashSet<>();
        for (Map.Entry<Character, Set<Character>> entry :adjacencyList.entrySet()) {
            if (!dfs(adjacencyList, entry.getKey(), result, visited, new HashSet<>())) {
                return "";
            }
        }

        return result.reverse().toString();
    }

    // topological sort basically
    private static boolean dfs(
            Map<Character, Set<Character>> adjacencyList,
            char node,
            StringBuilder result,
            Set<Character> visited,
            Set<Character> pathVisited
    ) {
        if (visited.contains(node)) {
            return true;
        }
        if (pathVisited.contains(node)) {
            return false;
        }

        pathVisited.add(node);
        for (char nextNode : adjacencyList.get(node)) {
            if (!dfs(adjacencyList, nextNode, result, visited, pathVisited)) {
                return false;
            }
        }
        pathVisited.remove(node);

        result.append(node);
        visited.add(node);
        return true;
    }
}
