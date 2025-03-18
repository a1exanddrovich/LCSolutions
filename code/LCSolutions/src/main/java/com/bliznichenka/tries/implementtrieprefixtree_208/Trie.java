package com.bliznichenka.tries.implementtrieprefixtree_208;

import java.util.HashMap;
import java.util.Map;

public class Trie {
    private final Node root = new Node();

    public void insert(String word) {
        Node cur = root;
        for (char c : word.toCharArray()) {
            if (!cur.map.containsKey(c)) {
                cur.map.put(c, new Node());
            }
            cur = cur.map.get(c);
        }
        cur.isWord = true;
    }

    public boolean search(String word) {
        Node cur = root;
        for (char c : word.toCharArray()) {
            if (!cur.map.containsKey(c)) {
                return false;
            }
            cur = cur.map.get(c);
        }
        return cur.isWord;
    }

    public boolean startsWith(String prefix) {
        Node cur = root;
        for (char c : prefix.toCharArray()) {
            if (!cur.map.containsKey(c)) {
                return false;
            }
            cur = cur.map.get(c);
        }
        return true;
    }

    private static class Node {
        private final Map<Character, Node> map = new HashMap<>();
        private boolean isWord;
    }
}
