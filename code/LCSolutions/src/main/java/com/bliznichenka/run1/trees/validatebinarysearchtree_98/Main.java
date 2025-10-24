package com.bliznichenka.run1.trees.validatebinarysearchtree_98;

import com.bliznichenka.run1.trees.TreeNode;
import com.bliznichenka.run1.trees.TreeNodeUtils;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();

        TreeNode root = TreeNodeUtils.getDefaultBst();

        System.out.println(s.isValidBST(root));
    }
}
