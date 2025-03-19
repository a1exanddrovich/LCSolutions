package com.bliznichenka.tries.extracharactersinastring_2707;

import java.util.*;

public class Solution {
    private final Map<Integer, Integer> cache = new HashMap<>();
    private final Trie trie = new Trie();

    public int minExtraChar(String s, String[] dictionary) {
        trie.insertAll(dictionary);
        cache.put(s.length(), 0);
        return dfs(s, 0);
    }

    private int dfs(String s, int index) {
        if (cache.containsKey(index)) {
            return cache.get(index);
        }

        int res = 1 + dfs(s, index + 1);

        Trie.Node cur = trie.root;
        for (int j = index; j < s.length(); j++) {
            if (cur.map.containsKey(s.charAt(j))) {
                cur = cur.map.get(s.charAt(j));
                if (cur.isWord) {
                    res = Math.min(res, dfs(s, j + 1));
                }
            } else {
                break;
            }
        }

        cache.put(index, res);
        return res;
    }

    private static final class Trie {
        private final Node root = new Node();

        private void insertAll(String[] dictionary) {
            for (String word : dictionary) {
                Node cur = root;

                for (char c : word.toCharArray()) {
                    if (!cur.map.containsKey(c)) {
                        cur.map.put(c, new Node());
                    }
                    cur = cur.map.get(c);
                }
                cur.isWord = true;
            }
        }

        private static final class Node {
            private final Map<Character, Node> map = new HashMap<>();
            private boolean isWord;
        }
    }

//    private final Map<Integer, Integer> cache = new HashMap<>();
//
//    public int minExtraChar(String s, String[] dictionary) {
//        Set<String> words = new HashSet<>(Arrays.asList(dictionary));
//        cache.put(s.length(), 0);
//        return dfs(s, 0, words);
//    }
//
//    private int dfs(String s, int i, Set<String> words) {
//        if (cache.containsKey(i)) {
//            return cache.get(i);
//        }
//
//        int res = 1 + dfs(s, i + 1, words);
//
//        for (int j = i; j < s.length(); j++) {
//            if (words.contains(s.substring(i, j + 1))) {
//                res = Math.min(res, dfs(s, j + 1, words));
//            }
//        }
//
//        cache.put(i, res);
//        return res;
//    }
}
