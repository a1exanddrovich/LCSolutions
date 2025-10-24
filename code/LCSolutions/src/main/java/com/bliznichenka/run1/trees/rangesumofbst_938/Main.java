package com.bliznichenka.run1.trees.rangesumofbst_938;

import com.bliznichenka.run1.trees.TreeNode;
import com.bliznichenka.run1.trees.TreeNodeUtils;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();

        int low = 7;
        int high = 15;
        TreeNode root = TreeNodeUtils.deserializePreorder("10 5 3 X X 7 X X 15 X 18 X X");

        System.out.println(s.rangeSumBST(root, low, high));
    }
}
