package com.bliznichenka.trees.insertintoabinarysearchtree_701;

import com.bliznichenka.trees.TreeNode;
import com.bliznichenka.trees.TreeNodeUtils;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();

        TreeNode root = TreeNodeUtils.getFullDefaultBst();
        int val = 10;

        TreeNode result = s.insertIntoBST(root, val);
        TreeNodeUtils.display(result);
    }
}
