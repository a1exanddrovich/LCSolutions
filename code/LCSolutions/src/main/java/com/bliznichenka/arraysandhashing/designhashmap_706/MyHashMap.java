package com.bliznichenka.arraysandhashing.designhashmap_706;

import java.util.Arrays;

public class MyHashMap {
    private static final int N = 1000;

    private final Node[] array = new Node[N];

    public MyHashMap() {
        Arrays.fill(array, new Node(-1, -1));
    }

    public void put(int key, int value) {
        Node curNode = array[hash(key)];

        while (curNode.next != null) {
            if (curNode.next.key == key) {
                curNode.next.val = value;
                return;
            }
            curNode = curNode.next;
        }

        curNode.next = new Node(key, value);
    }

    public int get(int key) {
        Node curNode = array[hash(key)];

        while (curNode.next != null) {
            if (curNode.next.key == key) {
                return curNode.next.val;
            }
            curNode = curNode.next;
        }

        return -1;
    }

    public void remove(int key) {
        Node curNode = array[hash(key)];

        while (curNode.next != null) {
            if (curNode.next.key == key) {
                curNode.next = curNode.next.next;
                return;
            }
            curNode = curNode.next;
        }
    }

    private int hash(int key) {
        return key % N;
    }

    private static final class Node {
        private final int key;
        private int val;
        private Node next;

        private Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
}
