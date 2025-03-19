package com.bliznichenka.tries.wordsearchii_212;

import javafx.util.Pair;

import java.util.*;

public class Solution {
    private final Trie trie = new Trie();

    public List<String> findWords(char[][] board, String[] words) {
        trie.insertAll(words);
        List<String> result = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                List<String> curList = new ArrayList<>();
                dfs(board,
                    i,
                    j,
                    curList,
                    new StringBuilder(),
                    trie.root,
                    new HashSet<>()
                );
                result.addAll(curList);
            }
        }
        return result;
    }

    private void dfs(
            char[][] board,
            int i,
            int j,
            List<String> curList,
            StringBuilder curWord,
            Trie.Node node,
            Set<Pair<Integer, Integer>> visited
    ) {
        if (i < 0 || i >= board.length
                || j < 0 || j >= board[0].length
                || visited.contains(new Pair<>(i, j))
                || !node.map.containsKey(board[i][j])) {
            return;
        }
        node = node.map.get(board[i][j]);
        visited.add(new Pair<>(i, j));
        curWord.append(board[i][j]);
        if (node.isWord) {
            curList.add(curWord.toString());
            // needed in order not to add the same word multiple times
            node.isWord = false;
        }

        List<List<Integer>> moves = List.of(
                List.of(0, -1),
                List.of(1, 0),
                List.of(0, 1),
                List.of(-1, 0)
        );
        for (List<Integer> move : moves) {
            int nextI = i + move.get(0);
            int nextJ = j + move.get(1);
            dfs(board,
                nextI,
                nextJ,
                curList,
                curWord,
                node,
                visited
            );
        }

        visited.remove(new Pair<>(i, j));
        curWord.deleteCharAt(curWord.length() - 1);
    }

    private static final class Trie {
        private final Node root = new Node();

        private void insertAll(String[] words) {
            for (String word : words) {
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
}
