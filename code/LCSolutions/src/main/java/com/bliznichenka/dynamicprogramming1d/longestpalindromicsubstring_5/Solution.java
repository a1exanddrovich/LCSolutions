package com.bliznichenka.dynamicprogramming1d.longestpalindromicsubstring_5;

public class Solution {
    public String longestPalindrome(String s) {
        int from = 0;
        int to = 0;

        for (int i = 0; i < s.length(); i++) {
            int l = i - 1;
            int r = i + 1;

            while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                if (r - l + 1 > to - from + 1) {
                    from = l;
                    to = r;
                }
                l--;
                r++;
            }

            l = i - 1;
            r = i;
            while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                if (r - l + 1 > to - from + 1) {
                    from = l;
                    to = r;
                }
                l--;
                r++;
            }
        }

        return s.substring(from, to + 1);
    }
}
