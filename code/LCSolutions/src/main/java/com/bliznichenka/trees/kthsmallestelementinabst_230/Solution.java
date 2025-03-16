package com.bliznichenka.trees.kthsmallestelementinabst_230;

import com.bliznichenka.trees.TreeNode;

import java.util.Stack;

public class Solution {
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();

        TreeNode cur = root;
        while (!stack.isEmpty() || cur != null) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }

            cur = stack.pop();
            k--;
            if (k == 0) {
                return cur.val;
            }
            cur = cur.right;
        }

        return -1;
    }
}
