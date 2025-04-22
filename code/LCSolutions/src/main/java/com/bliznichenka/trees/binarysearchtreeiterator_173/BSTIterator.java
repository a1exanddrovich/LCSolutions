package com.bliznichenka.trees.binarysearchtreeiterator_173;

import com.bliznichenka.trees.TreeNode;

import java.util.Stack;

/*
Initially I implemented this as a regular inorder dfs. There was c lass level pointer pointing at the current node
like in the regular dfs.

But in the Neetcode video a solution is slightly different and is below. The main difference is that we always have the
cur pointer null because we try to go as far left as possible (after saving the stack top) before returning the saved result,
so when we call the next method we have already traversed the left subtree. This is really better a bit:)
 */
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
