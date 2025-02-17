package com.bliznichenka.slidingwindow.longestrepeatingcharacterreplacement_424;

import java.util.HashMap;
import java.util.Map;

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

    public int characterReplacement1(String s, int k) {
        Map<Character, Integer> window = new HashMap<>();
        for (int i = 0; i < 26; i++) {
            window.put((char) ('A' + i), 0);
        }

        int result = 0;

        int l = 0;
        for (int r = 0; r < s.length(); r++) {
            window.put(s.charAt(r), window.get(s.charAt(r)) + 1);
            int requiredReplacements = (r - l + 1) - getMaxFrequency(window);

            while (requiredReplacements > k) {
                window.put(s.charAt(l), window.get(s.charAt(l)) - 1);
                l++;
                requiredReplacements = (r - l + 1) - getMaxFrequency(window);
            }

            result = Math.max(result, r - l + 1);
        }

        return result;
    }

    private static int getMaxFrequency(Map<Character, Integer> counter) {
        int result = 0;

        for (int count : counter.values()) {
            result = Math.max(result, count);
        }

        return result;
    }

    public int characterReplacement2(String s, int k) {
        Map<Character, Integer> window = new HashMap<>();
        for (int i = 0; i < 26; i++) {
            window.put((char) ('A' + i), 0);
        }

        int result = 0;
        int maxFrequency = 0;

        int l = 0;
        for (int r = 0; r < s.length(); r++) {
            window.put(s.charAt(r), window.get(s.charAt(r)) + 1);
            maxFrequency = Math.max(maxFrequency, window.get(s.charAt(r)));
            int requiredReplacements = (r - l + 1) - maxFrequency;

            while (requiredReplacements > k) {
                window.put(s.charAt(l), window.get(s.charAt(l)) - 1);
                l++;
                requiredReplacements = (r - l + 1) - maxFrequency;
            }

            result = Math.max(result, r - l + 1);
        }

        return result;
    }
}
