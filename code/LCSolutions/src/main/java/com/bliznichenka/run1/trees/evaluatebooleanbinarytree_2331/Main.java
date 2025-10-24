package com.bliznichenka.run1.trees.evaluatebooleanbinarytree_2331;

import com.bliznichenka.run1.trees.TreeNode;
import com.bliznichenka.run1.trees.TreeNodeUtils;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();

        TreeNode root = TreeNodeUtils.deserializePreorder("2 1 X X 3 0 X X 1 X X");
        System.out.println(s.evaluateTree(root));
    }
}
