package com.bliznichenka.intervals.mycalendari_729;

public class MyCalendar {
    private Node root;

    public boolean book(int startTime, int endTime) {
        if (root == null) {
            root = new Node(startTime, endTime);
            return true;
        }

        return tryInsertNode(root, startTime, endTime);
    }

    private boolean tryInsertNode(Node node, int start, int end) {
        if (end <= node.start) {
            if (node.left == null) {
                node.left = new Node(start, end);
                return true;
            } else {
                return tryInsertNode(node.left, start, end);
            }
        } else if (start >= node.end) {
            if (node.right == null) {
                node.right = new Node(start, end);
                return true;
            } else {
                return tryInsertNode(node.right, start, end);
            }
        } else {
            return false;
        }
    }

    private static final class Node {
        private final int start;
        private final int end;
        private Node left;
        private Node right;

        private Node(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
