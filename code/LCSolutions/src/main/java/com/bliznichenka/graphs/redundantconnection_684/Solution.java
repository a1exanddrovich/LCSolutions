package com.bliznichenka.graphs.redundantconnection_684;

import java.util.Arrays;

public class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        UnionFind uf = new UnionFind(edges.length);
        for (int[] edge : edges) {
            if (!uf.union(edge[0], edge[1])) {
                return edge;
            }
        }
        return null;
    }

    private static final class UnionFind {
        private final int[] parent;
        private final int[] rank;

        private UnionFind(int n) {
            parent = new int[n + 1];
            rank = new int[n + 1];

            for (int i = 1; i < n + 1; i++) {
                parent[i] = i;
            }
            Arrays.fill(rank, 1);
        }

        public boolean union(int n1, int n2) {
            int p1 = find(n1);
            int p2 = find(n2);

            if (p1 == p2) {
                return false;
            }

            if (rank[p2] > rank[p1]) {
                parent[p1] = p2;
                rank[p2] += rank[p1];
            } else {
                parent[p2] = p1;
                rank[p1] += rank[p2];
            }

            return true;
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
}
