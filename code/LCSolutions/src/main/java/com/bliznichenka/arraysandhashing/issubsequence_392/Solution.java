package com.bliznichenka.arraysandhashing.issubsequence_392;

public class Solution {
    public boolean isSubsequence(String s, String t) {
        int i = 0;

        for (int j = 0; j < t.length(); j++) {
            if (i == s.length()) {
                break;
            }
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
        }

        return i == s.length();
    }
}
