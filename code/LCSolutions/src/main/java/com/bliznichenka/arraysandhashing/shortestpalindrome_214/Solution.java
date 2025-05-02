package com.bliznichenka.arraysandhashing.shortestpalindrome_214;

public class Solution {
    // Rabin-Karp Algo
    public String shortestPalindrome(String s) {
        int hashBase = 29;
        long prefix = 0;
        long suffix = 0;
        long power = 1;
        int mod = 1_000_000_007;
        int palindromEndIndex = -1;

        for (int i = 0; i < s.length(); i++) {
            int charMapping = (s.charAt(i) - 'a') + 1;

            prefix = (prefix * hashBase + charMapping) % mod;
            suffix = (suffix + charMapping * power) % mod;

            power = (power * hashBase) % mod;

            if (prefix == suffix) {
                palindromEndIndex = i;
            }
        }

        String toBeAppended = s.substring(palindromEndIndex + 1);
        StringBuilder reversed = new StringBuilder(toBeAppended).reverse();
        return reversed.append(s).toString();
    }
}
