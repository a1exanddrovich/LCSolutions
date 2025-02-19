package com.bliznichenka.slidingwindow.minimumwindowsubstring_76;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> counter = new HashMap<>();

        for (char c : t.toCharArray()) {
            counter.put(c, counter.getOrDefault(c, 0) + 1);
        }

        Map<Character, Integer> window = new HashMap<>();

        int start = 0;
        int end = s.length() + 10;

        int l = 0;
        for (int r = 0; r < s.length(); r++) {
            char right = s.charAt(r);
            window.put(right, window.getOrDefault(right, 0) + 1);

            while (isIncluded(counter, window)) {
                if (r - l + 1 < end - start + 1) {
                    start = l;
                    end = r;
                }
                char left = s.charAt(l);
                window.put(left, window.get(left) - 1);
                l++;
            }
        }

        if (end == (s.length() + 10)) {
            return "";
        } else {
            return s.substring(start, end + 1);
        }
    }

    private static boolean isIncluded(Map<Character, Integer> counter,
                                      Map<Character, Integer> window) {
        for (Map.Entry<Character, Integer> entry : counter.entrySet()) {
            if (!window.containsKey(entry.getKey())
                    || window.get(entry.getKey()) < entry.getValue()) {
                return false;
            }
        }

        return true;
    }
}
