package com.bliznichenka.trees.rangesumofbst_938;

import com.bliznichenka.trees.TreeNode;

public class Solution {
    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) {
            return 0;
        }

        if (root.val < low) {
            return rangeSumBST(root.right, low, high);
        } else if (root.val > high) {
            return rangeSumBST(root.left, low, high);
        } else {
            return root.val
                    + rangeSumBST(root.right, low, high)
                    + rangeSumBST(root.left, low, high);
        }
    }
}
