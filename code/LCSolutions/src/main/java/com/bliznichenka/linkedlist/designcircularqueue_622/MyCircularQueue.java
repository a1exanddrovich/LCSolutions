package com.bliznichenka.linkedlist.designcircularqueue_622;

public class MyCircularQueue {
    private final int k;
    private final Node dummy = new Node(-1);
    private int size;
    private Node head = dummy;
    private Node tail = dummy;

    public MyCircularQueue(int k) {
        this.k = k;
    }

    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        }

        tail.next = new Node(value);
        tail = tail.next;
        size++;
        return true;
    }

    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }

        head = head.next;
        size--;
        return true;
    }

    public int Front() {
        return isEmpty() ? -1 : head.next.val;
    }

    public int Rear() {
        return isEmpty() ? -1 : tail.val;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == k;
    }

    private static final class Node {
        private final int val;
        private Node next;

        private Node(int val) {
            this.val = val;
        }
    }
}
