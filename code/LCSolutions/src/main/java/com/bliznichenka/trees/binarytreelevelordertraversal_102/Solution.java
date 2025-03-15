package com.bliznichenka.trees.binarytreelevelordertraversal_102;

import com.bliznichenka.trees.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return List.of();
        }

        List<List<Integer>> result = new ArrayList<>();
        Deque<TreeNode> deque = new ArrayDeque<>();

        deque.addFirst(root);
        while (!deque.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int len = deque.size();
            for (int i = 0; i < len; i++) {
                TreeNode polled = deque.pollLast();
                level.add(polled.val);
                if (polled.left != null) {
                    deque.addFirst(polled.left);
                }
                if (polled.right != null) {
                    deque.addFirst(polled.right);
                }
            }
            result.add(level);
        }

        return result;
    }
}
