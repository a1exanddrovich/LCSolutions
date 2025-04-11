package com.bliznichenka.dynamicprogramming2d.interleavingstring_97;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        String s1 = "aabcc";
        String s2 = "dbbca";
        String s3 = "aadbbcbcac";
        System.out.println(solution.isInterleave(s1, s2, s3));
    }
}
