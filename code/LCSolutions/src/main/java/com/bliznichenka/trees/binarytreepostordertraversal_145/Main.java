package com.bliznichenka.trees.binarytreepostordertraversal_145;

import com.bliznichenka.trees.TreeNode;
import com.bliznichenka.trees.TreeNodeUtils;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode root = TreeNodeUtils.getDefault();
        System.out.println(s.postorderTraversal(root));
    }
}
