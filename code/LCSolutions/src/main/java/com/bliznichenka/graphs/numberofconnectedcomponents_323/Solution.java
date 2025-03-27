package com.bliznichenka.graphs.numberofconnectedcomponents_323;

import java.util.Arrays;

public class Solution {
    public int countComponents(int n, int[][] edges) {
        UnionFind uf = new UnionFind(n);

        int res = n;
        for (int[] edge : edges) {
            res -= uf.union(edge[0], edge[1]);
        }

        return res;
    }

    private static final class UnionFind {
        private final int[] parent;
        private final int[] rank;

        private UnionFind(int n) {
            parent = new int[n];
            rank = new int[n];

            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }

            Arrays.fill(rank, 1);
        }

        public int union(int node1, int node2) {
            int par1 = find(node1);
            int par2 = find(node2);

            if (par1 == par2) {
                return 0;
            }

            if (rank[par2] > rank[par1]) {
                parent[par1] = par2;
                rank[par2] += rank[par1];
            } else {
                parent[par2] = par1;
                rank[par1] += rank[par2];
            }
            return 1;
        }

        private int find(int node) {
            int result = node;
            while (result != parent[result]) {
                parent[result] = parent[parent[result]];
                result = parent[result];
            }
            return result;
        }
    }

//    public int countComponents(int n, int[][] edges) {
//        int components = 0;
//        Set<Integer> visited = new HashSet<>();
//        Map<Integer, List<Integer>> adjacencyList = new HashMap<>();
//
//        for (int i = 0; i < n; i++) {
//            adjacencyList.put(i, new ArrayList<>());
//        }
//
//        for (int[] edge : edges) {
//            adjacencyList.get(edge[0]).add(edge[1]);
//            adjacencyList.get(edge[1]).add(edge[0]);
//        }
//
//        for (int i = 0; i < n; i++) {
//            int exploredNodes = dfs(adjacencyList, visited, i);
//            if (exploredNodes > 0) {
//                components++;
//            }
//        }
//
//        return components;
//    }
//
//    private static int dfs(
//            Map<Integer, List<Integer>> adjacencyList,
//            Set<Integer> visited,
//            int i
//    ) {
//        if (visited.contains(i)) {
//            return 0;
//        }
//
//        int res = 1;
//        visited.add(i);
//        for (int nextI : adjacencyList.get(i)) {
//            res += dfs(adjacencyList, visited, nextI);
//        }
//
//        return res;
//    }
}
