package com.bliznichenka.trees.sametree_100;

import com.bliznichenka.trees.TreeNode;
import com.bliznichenka.trees.TreeNodeUtils;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode root1 = TreeNodeUtils.getDefault();
        TreeNode root2 = TreeNodeUtils.getDefaultWithNullifiedLeft();

        System.out.println(s.isSameTree(root1, root2));
    }
}
