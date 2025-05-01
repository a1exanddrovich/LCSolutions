package com.bliznichenka.arraysandhashing.appendcharacterstostringtomakesubsequence_2486;

public class Solution {
    public int appendCharacters(String s, String t) {
        int j = 0;

        for (int i = 0; i < s.length(); i++) {
            if (j == t.length()) {
                break;
            }
            if (s.charAt(i) == t.charAt(j)) {
                j++;
            }
        }

        return t.length() - j;
    }
}
