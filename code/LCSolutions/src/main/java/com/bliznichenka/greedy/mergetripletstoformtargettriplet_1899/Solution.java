package com.bliznichenka.greedy.mergetripletstoformtargettriplet_1899;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        Set<Integer> result = new HashSet<>();

        for (int[] triplet : triplets) {
            if (triplet[0] > target[0]
                    || triplet[1] > target[1]
                    || triplet[2] > target[2]) {
                continue;
            }

            for (int i = 0; i < 3; i++) {
                if (triplet[i] == target[i]) {
                    result.add(i);
                }
            }
        }

        return result.size() == 3;
    }
}
