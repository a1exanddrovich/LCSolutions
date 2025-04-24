package com.bliznichenka.advancedgraphs.theearliestmomentwheneveryonebecomefriends_1101;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public int earliestAcq(int[][] logs, int n) {
        Arrays.sort(logs, Comparator.comparingInt(log -> log[0]));

        UnionFind uf = new UnionFind(n);

        for (int[] log : logs) {
            int time = log[0];
            int x = log[1];
            int y = log[2];

            uf.union(x, y);

            if (uf.getCount() == 1) {
                return time;
            }
        }

        return -1;
    }

    private static final class UnionFind {
        private final int[] par;
        private final int[] rank;
        private int count;

        private UnionFind(int n) {
            rank = new int[n];
            par = new int[n];
            for (int i = 0; i < n; i++) {
                par[i] = i;
            }
            count = n;
        }

        private int find(int x) {
            int res = x;
            while (res != par[res]) {
                res = par[res];
                par[res] = par[par[res]];
            }
            return res;
        }

        private void union(int x1, int x2) {
            int par1 = find(x1);
            int par2 = find(x2);

            if (par1 == par2) {
                return;
            }

            if (rank[par1] > rank[par2]) {
                par[par2] = par1;
                rank[par1]++;
            } else {
                par[par1] = par2;
                rank[par2]++;
            }

            count--;
        }

        private int getCount() {
            return count;
        }
    }
}
