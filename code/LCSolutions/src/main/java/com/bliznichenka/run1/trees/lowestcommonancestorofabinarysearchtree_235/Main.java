package com.bliznichenka.run1.trees.lowestcommonancestorofabinarysearchtree_235;

import com.bliznichenka.run1.trees.TreeNode;
import com.bliznichenka.run1.trees.TreeNodeUtils;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode root = TreeNodeUtils.getFullDefaultBst();

        TreeNode p = root.right.left;
        TreeNode q = root.right.right;

        System.out.println(s.lowestCommonAncestor(root, p, q).val);
    }
}
