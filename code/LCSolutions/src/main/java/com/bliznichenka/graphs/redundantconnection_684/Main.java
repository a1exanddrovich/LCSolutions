package com.bliznichenka.graphs.redundantconnection_684;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Solution s = new Solution();

        int[][] edges = {
                {1, 2}, {1, 3}, {2, 3}
        };
        System.out.println(Arrays.toString(s.findRedundantConnection(edges)));
    }

}
