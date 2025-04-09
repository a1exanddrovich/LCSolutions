package com.bliznichenka.greedy.gasstation_134;

public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int gasSum = 0;
        for (int g : gas) {
            gasSum += g;
        }
        int costSum = 0;
        for (int c : cost) {
            costSum += c;
        }

        if (gasSum < costSum) {
            return -1;
        }

        int total = 0;
        int resIndex = 0;
        for (int i = 0; i < gas.length; i++) {
            int diff = gas[i] - cost[i];
            total += diff;
            if (total < 0) {
                total = 0;
                resIndex = i + 1;
            }
        }
        return resIndex;
    }
}
