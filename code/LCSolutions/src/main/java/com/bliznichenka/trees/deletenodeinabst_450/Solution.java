package com.bliznichenka.trees.deletenodeinabst_450;

import com.bliznichenka.trees.TreeNode;

public class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }

        if (key > root.val) {
            root.right = deleteNode(root.right, key);
            return root;
        } else if (key < root.val) {
            root.left = deleteNode(root.left, key);
            return root;
        } else {
            if (root.left == null && root.right == null) {
                return null;
            }

            if (root.left == null) {
                return root.right;
            }

            if (root.right == null) {
                return root.left;
            }

            int minVal = findMin(root.right);
            root.val = minVal;
            root.right = deleteNode(root.right, minVal);
            return root;
        }
    }

    private static int findMin(TreeNode node) {
        TreeNode cur = node;

        while (cur.left != null) {
            cur = cur.left;
        }

        return cur.val;
    }
}
