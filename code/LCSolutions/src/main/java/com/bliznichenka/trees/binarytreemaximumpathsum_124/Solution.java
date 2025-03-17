package com.bliznichenka.trees.binarytreemaximumpathsum_124;

import com.bliznichenka.trees.TreeNode;

public class Solution {
    private int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return max;
    }

    private int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int leftMax = dfs(node.left);
        int rightMax = dfs(node.right);

        int leftSum = node.val + leftMax;
        int rightSum = node.val + rightMax;

        max = Math.max(max, node.val);
        max = Math.max(max, leftSum);
        max = Math.max(max, rightSum);
        max = Math.max(max, leftMax + node.val + rightMax);

        return Math.max(node.val, Math.max(leftSum, rightSum));
    }
}
