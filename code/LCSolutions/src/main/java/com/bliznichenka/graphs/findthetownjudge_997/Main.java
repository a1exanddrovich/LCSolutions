package com.bliznichenka.graphs.findthetownjudge_997;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();

        int n = 3;
        int[][] trust = {{1, 3}, {2, 3}, {3, 1}};
        System.out.println(s.findJudge(n, trust));
    }
}
