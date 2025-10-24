package com.bliznichenka.run1.trees.insertintoabinarysearchtree_701;

import com.bliznichenka.run1.trees.TreeNode;
import com.bliznichenka.run1.trees.TreeNodeUtils;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();

        TreeNode root = TreeNodeUtils.getFullDefaultBst();
        int val = 10;

        TreeNode result = s.insertIntoBST(root, val);
        TreeNodeUtils.display(result);
    }
}
