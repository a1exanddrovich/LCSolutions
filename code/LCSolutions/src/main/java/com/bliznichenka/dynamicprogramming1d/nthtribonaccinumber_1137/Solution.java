package com.bliznichenka.dynamicprogramming1d.nthtribonaccinumber_1137;

public class Solution {
    public int tribonacci(int n) {
        int[] lastThree = {0, 1, 1};

        if (n <= 2) {
            return lastThree[n];
        }

        for (int i = 3; i <= n; i++) {
            int[] temp = {
                    lastThree[1],
                    lastThree[2],
                    lastThree[0] + lastThree[1] + lastThree[2]
            };
            lastThree = temp;
        }

        return lastThree[2];
    }
}
