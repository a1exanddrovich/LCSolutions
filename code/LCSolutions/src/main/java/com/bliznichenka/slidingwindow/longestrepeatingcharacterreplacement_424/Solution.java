package com.bliznichenka.slidingwindow.longestrepeatingcharacterreplacement_424;

public class Solution {
    public int characterReplacement(String s, int k) {
        int result = 0;

        for (int i = 0; i < 26; i++) {
            char cur = (char) ('A' + i);
            int replacements = k;
            int l = 0;
            for (int r = 0; r < s.length(); r++) {
                if (s.charAt(r) != cur) {
                    replacements--;
                }

                while (replacements < 0) {
                    if (s.charAt(l) != cur) {
                        replacements++;
                    }
                    l++;
                }

                result = Math.max(result, r - l + 1);
            }
        }

        return result;
    }
}
