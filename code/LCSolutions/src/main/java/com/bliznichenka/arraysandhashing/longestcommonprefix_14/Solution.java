package com.bliznichenka.arraysandhashing.longestcommonprefix_14;

public class Solution {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder commonPrefix = new StringBuilder();

        for (int i = 0; i < strs[0].length(); i++) {
            char curChar = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (i >= strs[j].length() || strs[j].charAt(i) != curChar) {
                    return commonPrefix.toString();
                }
            }
            commonPrefix.append(curChar);
        }

        return commonPrefix.toString();
    }
}
