package com.bliznichenka.backtracking.matchstickstosquare_473;

import java.util.Arrays;
import java.util.Collections;
import java.util.stream.IntStream;

public class Solution {
    public boolean makesquare(int[] matchsticks) {
        int sum = 0;
        for (int n : matchsticks) {
            sum += n;
        }

        if (sum % 4 != 0) {
            return false;
        }

        Integer[] arrayWork = new Integer[matchsticks.length];
        for (int i = 0; i < matchsticks.length; i++) {
            arrayWork[i] = matchsticks[i];
        }

        Arrays.sort(arrayWork, Collections.reverseOrder());
        int[] sides = {0, 0, 0, 0};
        return dfs(arrayWork, 0, sides, sum / 4);
    }

    private static boolean dfs(
            Integer[] matchsticks,
            int i,
            int[] sides,
            int targetSideLen
    ) {
        if (i >= matchsticks.length) {
            return true;
        }

        for (int side = 0; side < 4; side++) {
            if (sides[side] + matchsticks[i] <= targetSideLen) {
                sides[side] += matchsticks[i];
                if (dfs(matchsticks, i + 1, sides, targetSideLen)) {
                    return true;
                }
                sides[side] -= matchsticks[i];
            }
        }

        return false;
    }
}
