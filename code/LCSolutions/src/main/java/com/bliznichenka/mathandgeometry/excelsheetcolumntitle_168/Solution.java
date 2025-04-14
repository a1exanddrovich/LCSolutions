package com.bliznichenka.mathandgeometry.excelsheetcolumntitle_168;

public class Solution {
    public String convertToTitle(int columnNumber) {
        StringBuilder res = new StringBuilder();
        while (columnNumber > 0) {
            columnNumber--;
            int offset = columnNumber % 26;
            res.append((char) ('A' + offset));
            columnNumber /= 26;
        }
        return res.reverse().toString();
    }
}
