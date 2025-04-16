package com.bliznichenka.bitmanipulation.minimumarrayend_3133;

public class Solution {
    public long minEnd(int n, int x) {
        long res = x;
        for (int i = 0; i < n - 1; i++) {
            res++;
            res = res | x;
        }
        return res;
    }
}
