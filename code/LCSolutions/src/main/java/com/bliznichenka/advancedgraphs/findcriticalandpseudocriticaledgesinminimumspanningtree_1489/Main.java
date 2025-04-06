package com.bliznichenka.advancedgraphs.findcriticalandpseudocriticaledgesinminimumspanningtree_1489;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();

        int n = 4;
        int[][] edges = {{0,1,1},{0,3,1},{0,2,1},{1,2,1},{1,3,1},{2,3,1}};
        System.out.println(s.findCriticalAndPseudoCriticalEdges(n, edges));
    }
}
