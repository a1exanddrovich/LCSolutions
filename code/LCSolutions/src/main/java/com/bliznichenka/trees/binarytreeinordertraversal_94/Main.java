package com.bliznichenka.trees.binarytreeinordertraversal_94;

import com.bliznichenka.trees.TreeNode;
import com.bliznichenka.trees.TreeNodeUtils;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();

        TreeNode root = TreeNodeUtils.deserializePreorder("1 2 3 X X 4 X X 5 6 X X X");

        System.out.println(s.inorderTraversal(root));
    }
}
