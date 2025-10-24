package com.bliznichenka.run1.trees.subtreeofanothertree_572;

import com.bliznichenka.run1.trees.TreeNode;
import com.bliznichenka.run1.trees.TreeNodeUtils;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode tree = TreeNodeUtils.getDefault();
        TreeNode subtree = TreeNodeUtils.getDefaultSubtree();

        System.out.println(s.isSubtree(tree, subtree));
    }
}
