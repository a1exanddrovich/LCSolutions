package com.bliznichenka.stack.implementstackusingqueues_225;

//public class MyStack {
//    private Node head = new Node(-1);
//
//    public void push(int x) {
//        Node newHead = new Node(x);
//        head.next = newHead;
//        newHead.prev = head;
//        head = newHead;
//    }
//
//    public int pop() {
//        if (head.value == -1) {
//            return -1;
//        }
//        Node cur = head;
//        head = head.prev;
//        return cur.value;
//    }
//
//    public int top() {
//        return head.value;
//    }
//
//    public boolean empty() {
//        return head.value == -1;
//    }
//
//    private static final class Node {
//        private final int value;
//        private Node next;
//        private Node prev;
//
//        private Node(int value) {
//            this.value = value;
//        }
//    }
//}

import java.util.LinkedList;
import java.util.Queue;

public class MyStack {
    private final Queue<Integer> queue = new LinkedList<>();

    public void push(int x) {
        queue.add(x);
        for (int i = 0; i < queue.size() - 1; i++) {
            queue.add(queue.remove());
        }
    }

    public int pop() {
        return queue.remove();
    }

    public int top() {
        return queue.element();
    }

    public boolean empty() {
        return queue.isEmpty();
    }
}
