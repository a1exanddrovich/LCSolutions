package com.bliznichenka.trees.validatebinarysearchtree_98;

import com.bliznichenka.trees.TreeNode;

public class Solution {
    public boolean isValidBST(TreeNode root) {
        return dfs(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private static boolean dfs(TreeNode node, long min, long max) {
        if (node == null) {
            return true;
        }

        return node.val > min
                && node.val < max
                && dfs(node.left, min, node.val)
                && dfs(node.right, node.val, max);
    }
}
