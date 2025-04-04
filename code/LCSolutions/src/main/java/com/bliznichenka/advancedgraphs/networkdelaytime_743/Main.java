package com.bliznichenka.advancedgraphs.networkdelaytime_743;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();

        int[][] times = {{2, 1, 1}, {2, 3, 1}, {3, 4, 1}};
        int n = 4;
        int k = 2;
        System.out.println(s.networkDelayTime(times, n, k));
    }
}
