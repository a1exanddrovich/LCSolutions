package com.bliznichenka.run1.trees.searchinabinarysearchtree_700;

import com.bliznichenka.run1.trees.TreeNode;
import com.bliznichenka.run1.trees.TreeNodeUtils;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode root = TreeNodeUtils.getDefault();

        System.out.println(s.searchBST(root, 2));
    }
}
