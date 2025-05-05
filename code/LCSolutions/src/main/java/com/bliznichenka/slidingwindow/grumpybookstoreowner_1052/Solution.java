package com.bliznichenka.slidingwindow.grumpybookstoreowner_1052;

public class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int prefixSum = 0;
        int postfixSum = 0;
        for (int i = customers.length - 1; i >= 0; i--) {
            if (grumpy[i] == 0) {
                postfixSum += customers[i];
            }
        }

        int result = 0;
        int windowSum = 0;
        int l = 0;
        for (int r = 0; r < customers.length; r++) {
            windowSum += customers[r];
            if (r - l + 1 > minutes) {
                windowSum -= customers[l];
                if (grumpy[l] == 0) {
                    prefixSum += customers[l];
                }
                l++;
            }
            if (grumpy[r] == 0) {
                postfixSum -= customers[r];
            }
            result = Math.max(result, prefixSum + windowSum + postfixSum);
        }

        return result;
    }
}
