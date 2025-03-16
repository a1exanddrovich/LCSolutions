package com.bliznichenka.trees.deleteleaveswithagivenvalue_1325;

import com.bliznichenka.trees.TreeNode;

public class Solution {
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        return dfs(root, target);
    }

    private static TreeNode dfs(TreeNode node, int target) {
        if (node == null) {
            return null;
        }

        node.left = dfs(node.left, target);
        node.right = dfs(node.right, target);

        if (node.left == null && node.right == null && node.val == target) {
            return null;
        }

        return node;
    }
}
