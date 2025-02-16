package com.bliznichenka.slidingwindow.longestsubstringwithoutrepeatingcharacters_3;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> window = new HashSet<>();
        int result = 0;

        int l = 0;
        for (int r = 0; r < s.length(); r++) {
            while (window.contains(s.charAt(r))) {
                window.remove(s.charAt(l));
                l++;
            }

            window.add(s.charAt(r));
            result = Math.max(result, r - l + 1);
        }

        return result;
    }
}
