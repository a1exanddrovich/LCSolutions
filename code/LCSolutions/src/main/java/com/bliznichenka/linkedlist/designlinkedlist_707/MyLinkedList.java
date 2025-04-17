package com.bliznichenka.linkedlist.designlinkedlist_707;

public class MyLinkedList {
    private final Node head = new Node(-1);
    private final Node tail = new Node(-1);

    public MyLinkedList() {
        head.next = tail;
        tail.prev = head;
    }

    public int get(int index) {
        Node cur = head.next;
        while (cur != tail) {
            if (index == 0) {
                return cur.val;
            }
            index--;
            cur = cur.next;
        }
        return -1;
    }

    public void addAtHead(int val) {
        Node node = new Node(val);
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }

    public void addAtTail(int val) {
        Node node = new Node(val);
        node.next = tail;
        node.prev = tail.prev;
        tail.prev.next = node;
        tail.prev = node;
    }

    public void addAtIndex(int index, int val) {
        Node cur = head;
        while (cur != tail) {
            if (index == 0) {
                Node node = new Node(val);
                node.next = cur.next;
                node.prev = cur;
                cur.next.prev = node;
                cur.next = node;
                return;
            }
            index--;
            cur = cur.next;
        }
    }

    public void deleteAtIndex(int index) {
        Node cur = head.next;
        while (cur != tail) {
            if (index == 0) {
                Node prev = cur.prev;
                Node next = cur.next;
                prev.next = next;
                next.prev = prev;
                return;
            }
            index--;
            cur = cur.next;
        }
    }

    private static final class Node {
        private final int val;
        private Node next;
        private Node prev;

        private Node(int val) {
            this.val = val;
        }
    }
}
