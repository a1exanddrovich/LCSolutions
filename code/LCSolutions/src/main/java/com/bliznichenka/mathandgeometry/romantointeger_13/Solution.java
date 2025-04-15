package com.bliznichenka.mathandgeometry.romantointeger_13;

import java.util.Map;

public class Solution {
    public int romanToInt(String s) {
        Map<Character, Integer> romanToArabic = Map.of(
                'I', 1,
                'V', 5,
                'X', 10,
                'L', 50,
                'C', 100,
                'D', 500,
                'M', 1000
        );

        int res = romanToArabic.get(s.charAt(s.length() - 1));

        int prev = res;
        for (int i = s.length() - 2; i >= 0; i--) {
            int cur = romanToArabic.get(s.charAt(i));
            if (cur < prev) {
                res -= cur;
            } else {
                res += cur;
            }
            prev = cur;
        }

        return res;
    }
}
