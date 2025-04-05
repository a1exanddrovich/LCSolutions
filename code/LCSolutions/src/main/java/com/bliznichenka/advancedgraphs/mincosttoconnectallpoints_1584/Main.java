package com.bliznichenka.advancedgraphs.mincosttoconnectallpoints_1584;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();

        int[][] points = {{0, 0}, {2, 2}, {3, 10}, {5, 2}, {7, 0}};
        System.out.println(s.minCostConnectPoints(points));
    }
}
