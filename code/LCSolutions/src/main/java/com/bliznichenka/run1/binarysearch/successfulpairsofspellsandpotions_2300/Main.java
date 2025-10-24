package com.bliznichenka.run1.binarysearch.successfulpairsofspellsandpotions_2300;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] spells = {3, 1, 2};
        int[] potions = {8, 5, 8};
        long success = 16;
        System.out.println(Arrays.toString(s.successfulPairs(spells, potions, success)));
    }
}
