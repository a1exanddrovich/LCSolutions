package com.bliznichenka.backtracking.wordbreakii_140;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        String s = "catsanddog";
        List<String> wordDict = List.of("cat", "cats", "and", "sand", "dog");
        System.out.println(solution.wordBreak(s, wordDict));
    }
}
