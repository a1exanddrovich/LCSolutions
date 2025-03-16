package com.bliznichenka.trees.deleteleaveswithagivenvalue_1325;

import com.bliznichenka.trees.TreeNode;

public class Solution {
    public TreeNode removeLeafNodes(TreeNode node, int target) {
        if (node == null) {
            return null;
        }

        node.left = removeLeafNodes(node.left, target);
        node.right = removeLeafNodes(node.right, target);

        if (node.left == null && node.right == null && node.val == target) {
            return null;
        }

        return node;
    }
}
