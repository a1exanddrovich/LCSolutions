package com.bliznichenka.dynamicprogramming2d.regularexpressionmatching_10;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        String s = "aab";
        String p = "c*a*b";
        System.out.println(solution.isMatch(s, p));
    }
}
