package com.bliznichenka.trees.binarysearchtreeiterator_173;

import com.bliznichenka.trees.TreeNode;

import java.util.Stack;

public class BSTIterator {
    private final Stack<TreeNode> stack = new Stack<>();

    public BSTIterator(TreeNode root) {
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
    }

    public int next() {
        TreeNode popped = stack.pop();
        TreeNode cur = popped.right;
        while (cur != null) {
            stack.push(cur);
            cur = cur.left;
        }
        return popped.val;
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }
}
