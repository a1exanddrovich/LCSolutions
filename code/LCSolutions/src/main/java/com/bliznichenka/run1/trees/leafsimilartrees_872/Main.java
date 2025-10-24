package com.bliznichenka.run1.trees.leafsimilartrees_872;

import com.bliznichenka.run1.trees.TreeNode;
import com.bliznichenka.run1.trees.TreeNodeUtils;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();

        TreeNode root1 = TreeNodeUtils.deserializePreorder("1 2 X X 3 X X");
        TreeNode root2 = TreeNodeUtils.deserializePreorder("1 3 X X 2 X X");
        System.out.println(s.leafSimilar(root1, root2));
    }
}
