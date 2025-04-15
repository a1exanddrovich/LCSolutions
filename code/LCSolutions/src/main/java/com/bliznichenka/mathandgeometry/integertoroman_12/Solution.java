package com.bliznichenka.mathandgeometry.integertoroman_12;

import java.util.List;
import java.util.Map;

public class Solution {
    public String intToRoman(int num) {
        List<Map.Entry<String, Integer>> romans = List.of(
                Map.entry("M", 1000),
                Map.entry("CM", 900),
                Map.entry("D", 500),
                Map.entry("CD", 400),
                Map.entry("C", 100),
                Map.entry("XC", 90),
                Map.entry("L", 50),
                Map.entry("XL", 40),
                Map.entry("X", 10),
                Map.entry("IX", 9),
                Map.entry("V", 5),
                Map.entry("IV", 4),
                Map.entry("I", 1)
        );

        StringBuilder res = new StringBuilder();

        for (Map.Entry<String, Integer> entry : romans) {
            int count = num / entry.getValue();
            // append as many roman numerals as we got
            res.append(entry.getKey().repeat(count));
            num %= entry.getValue();
        }

        return res.toString();
    }
}
