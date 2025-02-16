package com.bliznichenka.twopointers.boatstosavepeople_881;

import java.util.Arrays;

public class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);

        int boats = 0;
        int l = 0;
        int r = people.length - 1;
        while (l <= r) {
            boats++;
            int leftWeight = limit - people[r];
            r--;

            if (l <= r && people[l] <= leftWeight) {
                l++;
            }
        }

        return boats;
    }
}
