package com.bliznichenka.run1.trees.maximumdepthofbinatytree_104;

import com.bliznichenka.run1.trees.TreeNode;
import com.bliznichenka.run1.trees.TreeNodeUtils;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode root = TreeNodeUtils.getDefault();

        System.out.println(s.maxDepth(root));
    }
}
