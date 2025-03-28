package com.bliznichenka.graphs.minimumheighttrees_310;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();

        int n = 9;
        int[][] edges = {{3, 0}, {3, 1}, {3, 2}, {3, 4}, {5, 4}, {4, 8}, {5, 6}, {5, 7}};
        System.out.println(s.findMinHeightTrees(n, edges));
    }
}
