package com.bliznichenka.trees.balancedbinarytree_110;

import com.bliznichenka.trees.TreeNode;
import javafx.util.Pair;

public class Solution {
    public boolean isBalanced(TreeNode root) {
        return dfs(root) != -1;
    }

    private static int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int l = dfs(node.left);
        int r = dfs(node.right);

        if (l == -1 || r == -1) {
            return -1;
        }

        if (Math.abs(l - r) > 1) {
            return -1;
        }

        return 1 + Math.max(l, r);
    }

//    public boolean isBalanced(TreeNode root) {
//        return dfs(root).getValue();
//    }
//
//    private static Pair<Integer, Boolean> dfs(TreeNode node) {
//        if (node == null) {
//            return new Pair<>(0, true);
//        }
//
//        Pair<Integer, Boolean> left = dfs(node.left);
//        Pair<Integer, Boolean> right = dfs(node.right);
//
//        if (Math.abs(left.getKey() - right.getKey()) <= 1
//                && left.getValue()
//                && right.getValue()) {
//            return new Pair<>(1 + Math.max(left.getKey(), right.getKey()), true);
//        }
//
//        return new Pair<>(0, false);
//    }
}
