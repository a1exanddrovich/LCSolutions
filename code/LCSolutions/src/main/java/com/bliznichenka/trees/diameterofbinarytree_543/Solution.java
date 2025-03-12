package com.bliznichenka.trees.diameterofbinarytree_543;

import com.bliznichenka.trees.TreeNode;

public class Solution {
    private int res;

    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return res;
    }

    private int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int leftHeight = dfs(node.left);
        int rightHeight = dfs(node.right);

        int diam = leftHeight + rightHeight;
        res = Math.max(res, diam);

        return 1 + Math.max(leftHeight, rightHeight);
    }
}
