package com.bliznichenka.trees.constructbinarytreefrompreorderandinordertraversal_105;

import com.bliznichenka.trees.TreeNodeUtils;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();

        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};

        TreeNodeUtils.display(s.buildTree(preorder, inorder));
    }
}
