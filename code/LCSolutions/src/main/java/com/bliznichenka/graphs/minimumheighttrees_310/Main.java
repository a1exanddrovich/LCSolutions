package com.bliznichenka.graphs.minimumheighttrees_310;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();

        int n = 4;
        int[][] edges = {{1, 0}, {1, 2}, {1, 3}};
        System.out.println(s.findMinHeightTrees(n, edges));
    }
}
