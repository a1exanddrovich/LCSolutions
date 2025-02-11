package com.bliznichenka.twopointers.validpalindromeii_680;

public class Solution {
    public boolean validPalindrome(String s) {
        int l = 0;
        int r = s.length() - 1;

        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                // try to remove l or else try to remove r.
                // if none of the worked out - return false
                return isPalindrome(s, l + 1, r) || isPalindrome(s, l, r - 1);
            }
            l++;
            r--;
        }

        return true;
    }

    private static boolean isPalindrome(String s, int start, int end) {
        int l = start;
        int r = end;

        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }

        return true;
    }
}
