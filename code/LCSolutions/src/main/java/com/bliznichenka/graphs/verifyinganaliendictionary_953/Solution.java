package com.bliznichenka.graphs.verifyinganaliendictionary_953;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < order.length(); i++) {
            map.put(order.charAt(i), i);
        }

        for (int i = 1; i < words.length; i++) {
            String prev = words[i - 1];
            String cur = words[i];
            int j = 0;
            int k = 0;

            // iterate while both words are inbound and the char are equal
            while (j < prev.length()
                    && k < cur.length()
                    && prev.charAt(j) == cur.charAt(k)) {
                j++;
                k++;
            }

            // we know for sure either of the words has ended,
            // or one of them was longer than another in terms of equal chars

            // if we're inbound of both of them, the check the not equal char
            if (j < prev.length() && k < cur.length()) {
                if (map.get(prev.charAt(j)) > map.get(cur.charAt(k))) {
                    return false;
                }
            } else if (j < prev.length() || k < cur.length()) {
                // if one of them is ended, and another one is not, check the length
                if (prev.length() > cur.length()) {
                    return false;
                }
            }
        }

        return true;
    }
}
