package com.bliznichenka.trees.rangesumquerymutable_307;

// Basically implementation of the Segment Tree
public class NumArray {
    private final Node root;

    public NumArray(int[] nums) {
        root = buildSegmentTree(nums, 0, nums.length - 1);
    }

    public void update(int index, int val) {
        updateVal(root, index, val);
    }

    public int sumRange(int left, int right) {
        return queryRange(root, left, right);
    }

    private void updateVal(Node node, int index, int val) {
        if (node.start == node.end) {
            node.rangeSum = val;
            return;
        }

        int m = (node.start + node.end) / 2;
        if (index <= m) {
            updateVal(node.left, index, val);
        } else {
            updateVal(node.right, index, val);
        }

        node.rangeSum = node.left.rangeSum + node.right.rangeSum;
    }

    private int queryRange(Node node, int start, int end) {
        if (node.start == start && node.end == end) {
            return node.rangeSum;
        }

        int m = (node.start + node.end) / 2;
        if (start > m) {
            return queryRange(node.right, start, end);
        } else if (end <= m) {
            return queryRange(node.left, start, end);
        } else {
            return queryRange(node.left, start, m) + queryRange(node.right, m + 1, end);
        }
    }

    private Node buildSegmentTree(int[] nums, int start, int end) {
        if (start == end) {
            Node node = new Node(start, end, null, null);
            node.rangeSum = nums[start];
            return node;
        }

        int m = (start + end) / 2;
        Node left = buildSegmentTree(nums, start, m);
        Node right = buildSegmentTree(nums, m + 1, end);

        Node node = new Node(start, end, left, right);
        node.rangeSum = left.rangeSum + right.rangeSum;
        return node;
    }

    private static final class Node {
        private int rangeSum;

        private final int start;
        private final int end;

        private final Node left;
        private final Node right;

        private Node(int start, int end, Node left, Node right) {
            this.start = start;
            this.end = end;
            this.left = left;
            this.right = right;
        }
    }
}
