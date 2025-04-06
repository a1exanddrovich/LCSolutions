package com.bliznichenka.advancedgraphs.greatestcommondivisortraversal_2709;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public boolean canTraverseAllPairs(int[] nums) {
        UnionFind uf = new UnionFind(nums.length);
        Map<Integer, Integer> factorToIndex = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int factor = 2;
            while (factor * factor <= nums[i]) {
                if (nums[i] % factor == 0) {
                    if (factorToIndex.containsKey(factor)) {
                        uf.union(factorToIndex.get(factor), i);
                    } else {
                        factorToIndex.put(factor, i);
                    }
                    while (nums[i] % factor == 0) {
                        nums[i] /= factor;
                    }
                }
                factor++;
            }
            if (nums[i] > 1) {
                if (factorToIndex.containsKey(nums[i])) {
                    uf.union(factorToIndex.get(nums[i]), i);
                } else {
                    factorToIndex.put(nums[i], i);
                }
            }
        }

        return uf.isConnected();
    }

    private static final class UnionFind {
        private final int[] par;
        private final int[] rank;
        private int n;

        private UnionFind(int n) {
            par = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) {
                par[i] = i;
            }
            Arrays.fill(rank, 1);
            this.n = n;
        }

        private int find(int x) {
            int res = x;
            while (par[res] != res) {
                par[res] = par[par[res]];
                res = par[res];
            }
            return res;
        }

        private void union(int x1, int x2) {
            int p1 = find(x1);
            int p2 = find(x2);

            if (p1 == p2) {
                return;
            }

            if (rank[p1] < rank[p2]) {
                par[p1] = p2;
                rank[p2] += rank[p1];
            } else {
                par[p2] = p1;
                rank[p1] += rank[p2];
            }
            n--;
        }

        private boolean isConnected() {
            return n == 1;
        }
    }
}
