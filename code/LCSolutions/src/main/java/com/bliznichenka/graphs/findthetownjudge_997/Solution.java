package com.bliznichenka.graphs.findthetownjudge_997;

public class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] inbounds = new int[n + 1];
        int[] outbounds = new int[n + 1];

        for (int[] singleTrust : trust) {
            outbounds[singleTrust[0]]++;
            inbounds[singleTrust[1]]++;
        }

        for (int i = 1; i <= n; i++) {
            if (outbounds[i] == 0 && inbounds[i] == n - 1) {
                return i;
            }
        }

        return -1;
    }
}
