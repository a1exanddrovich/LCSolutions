package com.bliznichenka.run1.graphs.wordladder_127;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = List.of("hot","dot","dog","lot","log","cog");
        System.out.println(solution.ladderLength(beginWord, endWord, new ArrayList<>(wordList)));
    }
}
