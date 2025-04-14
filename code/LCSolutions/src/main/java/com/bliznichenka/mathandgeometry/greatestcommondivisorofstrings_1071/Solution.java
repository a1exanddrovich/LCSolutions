package com.bliznichenka.mathandgeometry.greatestcommondivisorofstrings_1071;

public class Solution {
    public String gcdOfStrings(String str1, String str2) {
        for (int i = Math.min(str1.length(), str2.length()); i > 0; i--) {
            if (isDivisor(str1, str2, i)) {
                return str2.substring(0, i);
            }
        }

        return "";
    }

    private static boolean isDivisor(String str1, String str2, int i) {
        if (str1.length() % i != 0 || str2.length() % i != 0) {
            return false;
        }

        String prefix = str1.substring(0, i);

        String res1 = prefix.repeat(str1.length() / i);
        String res2 = prefix.repeat(str2.length() / i);

        return str1.equals(res1) && str2.equals(res2);
    }
}
