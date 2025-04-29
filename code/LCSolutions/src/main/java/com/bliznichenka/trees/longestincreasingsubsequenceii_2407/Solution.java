package com.bliznichenka.trees.longestincreasingsubsequenceii_2407;

public class Solution {
    public int lengthOfLIS(int[] nums, int k) {
        int maxVal = 0;
        for (int n : nums) {
            maxVal = Math.max(maxVal, n);
        }

        SegmentTree tree = new SegmentTree(maxVal);
        for (int n : nums) {
            int start = Math.max(n - k, 0);
            int end = n - 1;
            int rangeMaxLen = tree.query(start, end);
            tree.update(n, rangeMaxLen + 1);
        }

        return tree.query(1, maxVal);
    }

    private static final class SegmentTree {
        private final Node root;

        public SegmentTree(int n) {
            root = buildSegmentTree(0, n);
        }

        public void update(int index, int val) {
            updateVal(root, index, val);
        }

        public int query(int l, int r) {
            return queryRange(root, l, r);
        }

        private void updateVal(Node node, int index, int val) {
            if (node.start == node.end) {
                node.maxVal = val;
                return;
            }

            int m = (node.start + node.end) / 2;
            if (index <= m) {
                updateVal(node.left, index, val);
            } else {
                updateVal(node.right, index, val);
            }

            node.maxVal = Math.max(node.left.maxVal, node.right.maxVal);
        }

        private int queryRange(Node node, int start, int end) {
            if (node.start == start && node.end == end) {
                return node.maxVal;
            }

            int m = (node.start + node.end) / 2;
            if (start > m) {
                return queryRange(node.right, start, end);
            } else if (end <= m) {
                return queryRange(node.left, start, end);
            } else {
                return Math.max(queryRange(node.left, start, m), queryRange(node.right, m + 1, end));
            }
        }

        private Node buildSegmentTree(int start, int end) {
            if (start == end) {
                Node node = new Node(start, end, null, null);
                node.maxVal = 0;
                return node;
            }

            int m = (start + end) / 2;
            Node left = buildSegmentTree(start, m);
            Node right = buildSegmentTree(m + 1, end);

            Node node = new Node(start, end, left, right);
            node.maxVal = Math.max(left.maxVal, right.maxVal);
            return node;
        }

        private static final class Node {
            private int maxVal;

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
}
