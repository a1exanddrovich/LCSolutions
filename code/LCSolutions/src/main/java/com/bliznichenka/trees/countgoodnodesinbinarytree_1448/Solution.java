package com.bliznichenka.trees.countgoodnodesinbinarytree_1448;

import com.bliznichenka.trees.TreeNode;

public class Solution {
    public int goodNodes(TreeNode root) {
        return dfs(root, root.val);
    }

    private static int dfs(TreeNode node, int curMax) {
        if (node == null) {
            return 0;
        }

        int result = 0;
        if (node.val >= curMax) {
            curMax = node.val;
            result++;
        }

        return result + dfs(node.left, curMax) + dfs(node.right, curMax);
    }
}
