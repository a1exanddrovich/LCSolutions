package com.bliznichenka.graphs.graphvalidtree_261;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();

        int n = 5;
        int[][] edges = {{0, 1}, {0, 2}, {0, 3}, {1, 4}};
        System.out.println(s.validTree(n, edges));
    }
}
