package com.bliznichenka.tries.designsddandsearchwordsdatastructure_211;

import java.util.HashMap;
import java.util.Map;

public class WordDictionary {
    private final Node root = new Node();

    public void addWord(String word) {
        Node cur = root;
        for (char c : word.toCharArray()) {
            if (!cur.children.containsKey(c)) {
                cur.children.put(c, new Node());
            }
            cur = cur.children.get(c);
        }
        cur.isWord = true;
    }

    public boolean search(String word) {
        return dfs(root, word.toCharArray(), 0);
    }

    private static boolean dfs(Node startNode, char[] word, int index) {
        Node cur = startNode;
        for (int i = index; i < word.length; i++) {
            if (word[i] == '.') {
                for (Node nextNode : cur.children.values()) {
                    if (dfs(nextNode, word, i + 1)) {
                        return true;
                    }
                }
                return false;
            } else {
                if (!cur.children.containsKey(word[i])) {
                    return false;
                }
                cur = cur.children.get(word[i]);
            }
        }

        return cur.isWord;
    }

    private static class Node {
        private final Map<Character, Node> children = new HashMap<>();
        private boolean isWord;
    }
}
