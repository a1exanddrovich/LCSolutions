package com.bliznichenka.slidingwindow.permutationinstring_567;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }

        Map<Character, Integer> s1Counter = new HashMap<>();
        for (char c : s1.toCharArray()) {
            s1Counter.put(c, s1Counter.getOrDefault(c, 0) + 1);
        }

        Map<Character, Integer> window = new HashMap<>();

        int l = 0;
        int r = 0;

        while (r + 1 <= s1.length()) {
            char cur = s2.charAt(r);
            window.put(cur, window.getOrDefault(cur, 0) + 1);
            r++;
        }

        while (r < s2.length()) {
            if (window.equals(s1Counter)) {
                return true;
            }

            char right = s2.charAt(r);
            char left = s2.charAt(l);
            window.put(right, window.getOrDefault(right, 0) + 1);
            window.put(left, window.get(left) - 1);
            if (window.get(left) == 0) {
                window.remove(left);
            }
            l++;
            r++;
        }

        return window.equals(s1Counter);
    }
}
