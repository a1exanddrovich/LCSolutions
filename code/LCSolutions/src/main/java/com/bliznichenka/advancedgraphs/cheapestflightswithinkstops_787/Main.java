package com.bliznichenka.advancedgraphs.cheapestflightswithinkstops_787;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();

        int n = 5;
        int[][] flights = {{0, 1, 5}, {1, 2, 5}, {0, 3, 2}, {3, 1, 2}, {1, 4, 1}, {4, 2, 1}};
        int src = 0;
        int dst = 2;
        int k = 2;
        System.out.println(s.findCheapestPrice(n, flights, src, dst, k));
    }
}
