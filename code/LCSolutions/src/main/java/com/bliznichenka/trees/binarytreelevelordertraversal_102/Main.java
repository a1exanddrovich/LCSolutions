package com.bliznichenka.trees.binarytreelevelordertraversal_102;

import com.bliznichenka.trees.TreeNode;
import com.bliznichenka.trees.TreeNodeUtils;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode root = TreeNodeUtils.getDefault();

        System.out.println(s.levelOrder(root));
    }
}
