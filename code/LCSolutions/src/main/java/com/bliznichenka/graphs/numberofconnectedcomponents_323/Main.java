package com.bliznichenka.graphs.numberofconnectedcomponents_323;

public class Main {

    public static void main(String[] args) {
        Solution s = new Solution();

        int n = 5;
        int[][] edges = {
                {0, 1}, {0, 2}, {3,4}
        };
        System.out.println(s.countComponents(n, edges));
    }

}
