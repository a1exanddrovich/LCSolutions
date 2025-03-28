package com.bliznichenka.graphs.wordladder_127;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> availableWords = new HashSet<>(wordList);

        if (!availableWords.contains(endWord)) {
            return 0;
        }

        Deque<String> deque = new ArrayDeque<>();
        deque.addFirst(beginWord);

        int level = 1;
        while (!deque.isEmpty()) {
            int len = deque.size();
            for (int i = 0; i < len; i++) {
                String polled = deque.pollLast();
                if (polled.equals(endWord)) {
                    return level;
                }

                List<String> generatedWords = generateNextWords(polled, availableWords);

                for (String nextWord : generatedWords) {
                    deque.addFirst(nextWord);
                }
            }
            level++;
        }

        return 0;
    }

    private static List<String> generateNextWords(String word, Set<String> words) {
        List<String> result = new ArrayList<>();
        StringBuilder curWord = new StringBuilder(word);
        for (int i = 0; i < word.length(); i++) {
            for (int j = 0; j < 26; j++) {
                curWord.setCharAt(i, (char) ('a' + j));
                String cur = curWord.toString();
                if (words.contains(cur)) {
                    result.add(cur);
                    words.remove(cur);
                }
            }
            curWord.setCharAt(i, word.charAt(i));
        }
        return result;
    }
}
