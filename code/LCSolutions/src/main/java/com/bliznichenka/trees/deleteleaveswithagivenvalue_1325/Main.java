package com.bliznichenka.trees.deleteleaveswithagivenvalue_1325;

import com.bliznichenka.trees.TreeNode;
import com.bliznichenka.trees.TreeNodeUtils;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();

        TreeNode root = TreeNodeUtils.deserializePreorder("1,2,2,X,X,X,3,2,X,X,4,X,X", ",");
        int target = 2;

        TreeNodeUtils.display(s.removeLeafNodes(root, target));
    }
}
