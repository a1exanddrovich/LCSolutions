package com.bliznichenka.arraysandhashing.canplaceflowers_605;

public class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int emptySlots = flowerbed[0] == 1 ? 0 : 1;

        for (int f : flowerbed) {
            if (f == 0) {
                emptySlots++;
            } else {
                n -= ((emptySlots - 1) / 2);
                emptySlots = 0;
            }
        }

        n -= emptySlots / 2;

        return n <= 0;
    }
}
