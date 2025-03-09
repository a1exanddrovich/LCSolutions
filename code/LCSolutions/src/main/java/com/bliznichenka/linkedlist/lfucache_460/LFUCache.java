package com.bliznichenka.linkedlist.lfucache_460;

import java.util.HashMap;
import java.util.Map;

class LFUCache {
    private final int capacity;
    // key - val
    private final Map<Integer, Integer> valueMap = new HashMap<>();
    // key - count
    private final Map<Integer, Integer> countMap = new HashMap<>();
    // count - linked list
    private final Map<Integer, LinkedList> listMap = new HashMap<>();
    private int lfuCount;

    public LFUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if (!valueMap.containsKey(key)) {
            return -1;
        }

        counter(key);
        return valueMap.get(key);
    }

    public void put(int key, int value) {
        // of the capacity is full but we try to insert a new value
        // then evict
        if (!valueMap.containsKey(key) && valueMap.size() == capacity) {
            int keyToDelete = listMap.get(lfuCount).removeLeft();
            valueMap.remove(keyToDelete);
            countMap.remove(keyToDelete);
        }

        valueMap.put(key, value);
        counter(key);
        lfuCount = Math.min(lfuCount, countMap.get(key));
    }

    // get the current frequency (count) of the given key
    // then increase it, remove it from the linked list with the prev count
    // and then add to the linked list with the increased count
    private void counter(int key) {
        int count = countMap.getOrDefault(key, 0);
        countMap.put(key, count + 1);

        listMap.putIfAbsent(count, new LinkedList());
        listMap.get(count).remove(key);

        listMap.putIfAbsent(count + 1, new LinkedList());
        listMap.get(count + 1).pushRight(key);

        // if the original count was the lfuCount and after the manipulations
        // the original count list got empty, then we want to increase the
        // lfu count since no values exist against the old lfucount
        if (count == lfuCount && listMap.get(count).size() == 0) {
            lfuCount++;
        }
    }

    private static final class LinkedList {
        private final Node left = new Node(-1);
        private final Node right = new Node(-1);
        private final Map<Integer, Node> map = new HashMap<>();

        private LinkedList() {
            left.next = right;
            right.prev = left;
        }

        private int size() {
            return map.size();
        }

        private void pushRight(int key) {
            Node node = new Node(key);
            map.put(key, node);

            Node left = right.prev;
            node.prev = left;
            node.next = right;

            left.next = node;
            right.prev = node;
        }

        private void remove(int key) {
            if (map.containsKey(key)) {
                Node node = map.get(key);

                Node left = node.prev;
                Node right = node.next;

                left.next = right;
                right.prev = left;

                map.remove(key);
            }
        }

        // this will just return the least recently used key
        private int removeLeft() {
            int key = left.next.key;
            remove(key);
            return key;
        }

        private static final class Node {
            private final int key;
            private Node prev;
            private Node next;

            private Node(int key) {
                this.key = key;
            }
        }
    }
}
