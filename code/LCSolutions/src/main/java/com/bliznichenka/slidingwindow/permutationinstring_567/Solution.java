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

    public boolean checkInclusion1(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }

        int matches = 0;
        int l = 0;
        int r = 0;
        int[] s1Array = new int[26];
        int[] s2Array = new int[26];

        while (r < s1.length()) {
            s1Array[s1.charAt(r) - 'a']++;
            s2Array[s2.charAt(r) - 'a']++;
            r++;
        }

        for (int i = 0; i < 26; i++) {
            if (s1Array[i] == s2Array[i]) {
                matches++;
            }
        }

        while (r < s2.length()) {
            if (matches == 26) {
                return true;
            }

            int right = s2.charAt(r) - 'a';
            s2Array[right]++;
            if (s2Array[right] - 1 == s1Array[right]) {
                matches--;
            } else if (s2Array[right] == s1Array[right]) {
                matches++;
            }

            int left = s2.charAt(l) - 'a';
            s2Array[left]--;
            if (s2Array[left] + 1 == s1Array[left]) {
                matches--;
            } else if (s2Array[left] == s1Array[left]) {
                matches++;
            }

            r++;
            l++;
        }

        return matches == 26;
    }
}
