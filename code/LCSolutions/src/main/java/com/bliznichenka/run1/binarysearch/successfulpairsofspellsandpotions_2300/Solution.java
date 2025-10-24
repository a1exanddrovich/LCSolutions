package com.bliznichenka.run1.binarysearch.successfulpairsofspellsandpotions_2300;

import java.util.Arrays;

public class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);

        int[] result = new int[spells.length];

        for (int i = 0; i < spells.length; i++) {
            int index = potions.length;

            int l = 0;
            int r = potions.length - 1;
            while (l <= r) {
                int m = l + (r - l) / 2;

                if ((long) spells[i] * potions[m] >= success) {
                    index = m;
                    r = m - 1;
                } else {
                    l = m + 1;
                }
            }

            result[i] = potions.length - index;
        }

        return result;
    }
}
