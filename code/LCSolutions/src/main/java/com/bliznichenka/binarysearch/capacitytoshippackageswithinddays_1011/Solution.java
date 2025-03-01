package com.bliznichenka.binarysearch.capacitytoshippackageswithinddays_1011;

public class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int l = 0;
        int r = 0;
        for (int weight : weights) {
            l = Math.max(l, weight);
            r += weight;
        }

        int minCapacity = r;
        while (l <= r) {
            int m = l + (r - l) / 2;

            int daysRequired = 1;
            int currentShipWeight = 0;
            for (int weight : weights) {
                if (currentShipWeight + weight > m) {
                    currentShipWeight = weight;
                    daysRequired++;
                } else {
                    currentShipWeight += weight;
                }
            }

            if (daysRequired > days) {
                l = m + 1;
            } else {
                minCapacity = m;
                r = m - 1;
            }
        }

        return minCapacity;
    }
}
