package com.bliznichenka.dynamicprogramming1d.wordbreak_139;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();

        String s = "neetcode";
        List<String> wordDict = List.of("neet", "code");
        System.out.println(solution.wordBreak(s, wordDict));
    }

}
