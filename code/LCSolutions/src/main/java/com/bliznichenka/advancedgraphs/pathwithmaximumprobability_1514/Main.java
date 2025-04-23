package com.bliznichenka.advancedgraphs.pathwithmaximumprobability_1514;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();

        int n = 3;
        int[][] edges = {{0, 1}, {1, 2}, {0, 2}};
        double[] succProb = {0.5, 0.5, 0.2};
        int start = 0;
        int end = 2;
        System.out.println(s.maxProbability(n, edges, succProb, start, end));
    }
}
