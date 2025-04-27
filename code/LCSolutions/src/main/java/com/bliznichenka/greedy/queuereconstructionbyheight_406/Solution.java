package com.bliznichenka.greedy.queuereconstructionbyheight_406;

import java.util.Arrays;

public class Solution {
    public int[][] reconstructQueue(int[][] people) {
        int[][] result = new int[people.length][];

        Arrays.sort(people, (p1, p2) -> {
            if (p1[0] == p2[0]) {
                return p1[1] - p2[1];
            }
            return p1[0] - p2[0];
        });

        for (int[] person : people) {
            int count = person[1];
            int j = 0;
            while (count > 0) {
                if (result[j] == null || result[j][0] >= person[0]) {
                    count--;
                }
                j++;
            }
            while (result[j] != null) {
                j++;
            }
            result[j] = new int[]{person[0], person[1]};
        }

        return result;
    }
}
