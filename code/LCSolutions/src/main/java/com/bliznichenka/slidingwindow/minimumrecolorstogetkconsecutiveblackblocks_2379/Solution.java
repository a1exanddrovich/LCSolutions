package com.bliznichenka.slidingwindow.minimumrecolorstogetkconsecutiveblackblocks_2379;

public class Solution {
    public int minimumRecolors(String blocks, int k) {
        int whiteBlocks = 0;
        int result = 0;

        int l = 0;
        int r = 0;
        while (r < k) {
            if (blocks.charAt(r) == 'W') {
                whiteBlocks++;
                result++;
            }
            r++;
        }

        while (r < blocks.length()) {
            if (blocks.charAt(r) == 'W') {
                whiteBlocks++;
            }
            r++;
            if (blocks.charAt(l) == 'W') {
                whiteBlocks--;
            }
            l++;
            result = Math.min(result, whiteBlocks);
        }

        return result;
    }
}
