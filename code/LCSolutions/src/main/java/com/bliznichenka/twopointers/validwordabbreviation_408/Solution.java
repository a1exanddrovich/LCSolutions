package com.bliznichenka.twopointers.validwordabbreviation_408;

public class Solution {
    public boolean validWordAbbreviation(String word, String abbr) {
        int i = 0;
        int j = 0;

        while (i < word.length() && j < abbr.length()) {
            if (word.charAt(i) == abbr.charAt(j)) {
                i++;
                j++;
            } else {
                if (Character.isLetter(abbr.charAt(j)) || abbr.charAt(j) == '0') {
                    return false;
                }
                StringBuilder num = new StringBuilder();
                while (j < abbr.length() && Character.isDigit(abbr.charAt(j))) {
                    num.append(abbr.charAt(j));
                    j++;
                }
                i += Integer.parseInt(num.toString());
            }
        }

        return i == word.length() && j == abbr.length();
    }
}
