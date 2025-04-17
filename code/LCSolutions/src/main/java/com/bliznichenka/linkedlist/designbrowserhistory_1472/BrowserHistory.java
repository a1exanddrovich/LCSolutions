package com.bliznichenka.linkedlist.designbrowserhistory_1472;

public class BrowserHistory {private Node cur;

    public BrowserHistory(String homepage) {
        cur = new Node(homepage);
    }

    public void visit(String url) {
        Node node = new Node(url);
        node.prev = cur;
        cur.next = node;
        cur = cur.next;
    }

    public String back(int steps) {
        while (cur.prev != null) {
            if (steps == 0) {
                return cur.url;
            }
            steps--;
            cur = cur.prev;
        }
        return cur.url;
    }

    public String forward(int steps) {
        while (cur.next != null) {
            if (steps == 0) {
                return cur.url;
            }
            steps--;
            cur = cur.next;
        }
        return cur.url;
    }

    private static final class Node {
        private final String url;
        private Node next;
        private Node prev;

        private Node(String url) {
            this.url = url;
        }
    }

}
