package com.bliznichenka.advancedgraphs.findcriticalandpseudocriticaledgesinminimumspanningtree_1489;

import java.util.*;

public class Solution {
    public List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] edges) {
        // [from, to, wei, index]
        List<List<Integer>> edgeList = new ArrayList<>();
        for (int i = 0; i < edges.length; i++) {
            edgeList.add(List.of(edges[i][0], edges[i][1], edges[i][2], i));
        }

        edgeList.sort(Comparator.comparingInt(a -> a.get(2)));

        int mstWeight = 0;
        UnionFind uf = new UnionFind(n);
        for (List<Integer> edge : edgeList) {
            if (uf.union(edge.get(0), edge.get(1))) {
                mstWeight += edge.get(2);
            }
        }

        List<Integer> critical = new ArrayList<>();
        List<Integer> pseudoCritical = new ArrayList<>();

        for (List<Integer> edge : edgeList) {
            // try to build mst w/o this edge
            uf = new UnionFind(n);
            int weight = 0;
            for (List<Integer> other : edgeList) {
                if (other.get(3).equals(edge.get(3))) {
                    continue;
                }
                if (uf.union(other.get(0), other.get(1))) {
                    weight += other.get(2);
                }
            }
            // if the components are not connected, or the weight is increased
            // then this is critical
            if (uf.getComps() > 1 || weight > mstWeight) {
                critical.add(edge.get(3));
                continue;
            }

            // force the current edge which is not critical to be included
            uf = new UnionFind(n);
            uf.union(edge.get(0), edge.get(1));
            weight = edge.get(2);
            for (List<Integer> other : edgeList) {
                if (uf.union(other.get(0), other.get(1))) {
                    weight += other.get(2);
                }
            }
            if (weight == mstWeight) {
                pseudoCritical.add(edge.get(3));
            }
        }

        return List.of(critical, pseudoCritical);
    }

    private static final class UnionFind {
        private final int[] parent;
        private final int[] rank;
        private int n;

        private UnionFind(int n) {
            parent = new int[n];
            rank = new int[n];
            this.n = n;
            for (int i = 0; i < n; i++) {
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
            n--;
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

        private int getComps() {
            return n;
        }
    }
}
