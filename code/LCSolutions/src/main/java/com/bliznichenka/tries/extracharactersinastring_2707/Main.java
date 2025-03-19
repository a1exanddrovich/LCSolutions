package com.bliznichenka.tries.extracharactersinastring_2707;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        String s = "catman";
        String[] dictionary = {"cat", "man", "atman"};
        System.out.println(solution.minExtraChar(s, dictionary));
    }
}
