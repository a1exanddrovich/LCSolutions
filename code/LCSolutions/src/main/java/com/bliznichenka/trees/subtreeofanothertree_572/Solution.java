package com.bliznichenka.trees.subtreeofanothertree_572;

import com.bliznichenka.trees.TreeNode;

public class Solution {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) {
            return false;
        }

        return isSameTree(root, subRoot)
                || isSubtree(root.left, subRoot)
                || isSubtree(root.right, subRoot);
    }

    private static boolean isSameTree(TreeNode r1, TreeNode r2) {
        if (r1 == null && r2 == null) {
            return true;
        }
        if (r1 == null || r2 == null) {
            return false;
        }

        return r1.val == r2.val
                && isSameTree(r1.left, r2.left)
                && isSameTree(r1.right, r2.right);
    }
}
