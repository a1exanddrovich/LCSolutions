package com.bliznichenka.trees.validatebinarysearchtree_98;

import com.bliznichenka.trees.TreeNode;
import com.bliznichenka.trees.TreeNodeUtils;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();

        TreeNode root = TreeNodeUtils.getDefaultBst();

        System.out.println(s.isValidBST(root));
    }
}
