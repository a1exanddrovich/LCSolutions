package com.bliznichenka.arraysandhashing.designhashset_705;

public class MyHashSet {
    private final static int N = 1000;

    private final Node[] array = new Node[N];

    public MyHashSet() {
        for (int i = 0; i < array.length; i++) {
            array[i] = new Node(-1);
        }
    }

    public void add(int key) {
        if (contains(key)) {
            return;
        }

        Node curNode = array[hash(key)];
        while (curNode.next != null) {
            curNode = curNode.next;
        }

        curNode.next = new Node(key);
    }

    public void remove(int key) {
        if (!contains(key)) {
            return;
        }

        Node curNode = array[hash(key)];
        // the key exists in the set for sure, no need to null checks
        while (curNode.next.val != key) {
            curNode = curNode.next;
        }

        curNode.next = curNode.next.next;
    }

    public boolean contains(int key) {
        Node curNode = array[hash(key)].next;

        while (curNode != null) {
            if (curNode.val == key) {
                return true;
            }

            curNode = curNode.next;
        }

        return false;
    }

    private static int hash(int val) {
        return val % N;
    }

    private static final class Node {
        private final int val;
        private Node next;

        private Node(int val) {
            this.val = val;
        }
    }
}
