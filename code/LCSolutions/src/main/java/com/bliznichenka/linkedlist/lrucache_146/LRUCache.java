package com.bliznichenka.linkedlist.lrucache_146;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    private final int capacity;
    private final Node left = new Node(-1, -1);
    private final Node right = new Node(-1, -1);
    private final Map<Integer, Node> map = new HashMap<>();

    public LRUCache(int capacity) {
        this.capacity = capacity;
        left.next = right;
        right.prev = left;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            remove(map.get(key));
            append(map.get(key));
            return map.get(key).val;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            remove(map.get(key));
        }

        Node node = new Node(key, value);
        map.put(key, node);
        append(node);

        if (map.size() > capacity) {
            Node toDelete = left.next;
            map.remove(toDelete.key);
            remove(toDelete);
        }
    }

    private void remove(Node node) {
        Node left = node.prev;
        Node right = node.next;

        left.next = right;
        right.prev = left;
    }

    private void append(Node node) {
        Node left = right.prev;

        node.prev = left;
        node.next = right;

        right.prev = node;
        left.next = node;
    }

    private static final class Node {
        private final int key;
        private final int val;
        private Node next;
        private Node prev;

        private Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
}
