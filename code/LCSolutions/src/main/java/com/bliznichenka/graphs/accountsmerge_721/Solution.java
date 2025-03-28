package com.bliznichenka.graphs.accountsmerge_721;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        UnionFind uf = new UnionFind(accounts.size());

        Map<String, Integer> emailToAccount = new HashMap<>();
        for (int i = 0; i < accounts.size(); i++) {
            for (int j = 1; j < accounts.get(i).size(); j++) {
                String email = accounts.get(i).get(j);
                if (emailToAccount.containsKey(email)) {
                    uf.union(emailToAccount.get(email), i);
                } else {
                    emailToAccount.put(email, i);
                }
            }
        }

        Map<Integer, List<String>> accountToEmails = new HashMap<>();
        for (Map.Entry<String, Integer> entry : emailToAccount.entrySet()) {
            int parentAccount = uf.find(entry.getValue());
            if (!accountToEmails.containsKey(parentAccount)) {
                accountToEmails.put(parentAccount, new ArrayList<>());
            }
            accountToEmails.get(parentAccount).add(entry.getKey());
        }

        List<List<String>> result = new ArrayList<>();

        for (Map.Entry<Integer, List<String>> entry : accountToEmails.entrySet()) {
            List<String> cur = new ArrayList<>();

            List<String> emails = entry.getValue();
            Collections.sort(emails);
            String accountName = accounts.get(entry.getKey()).get(0);

            cur.add(accountName);
            cur.addAll(emails);

            result.add(cur);
        }

        return result;
    }

    private static class UnionFind {
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

        private int find(int node) {
            int res = node;
            while (res != parent[res]) {
                parent[res] = parent[parent[res]];
                res = parent[res];
            }
            return res;
        }

        private void union(int n1, int n2) {
            int p1 = find(n1);
            int p2 = find(n2);

            if (p1 == p2) {
                return;
            }

            if (rank[p2] > rank[p1]) {
                parent[p1] = p2;
                rank[p2] += rank[p1];
            } else {
                parent[p2] = p1;
                rank[p1] += rank[p2];
            }
        }
    }
}
