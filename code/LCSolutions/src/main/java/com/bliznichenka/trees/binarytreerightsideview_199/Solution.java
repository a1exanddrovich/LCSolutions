package com.bliznichenka.trees.binarytreerightsideview_199;

import com.bliznichenka.trees.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) {
            return List.of();
        }

        List<Integer> result = new ArrayList<>();
        Deque<TreeNode> deque = new ArrayDeque<>();

        deque.addFirst(root);
        while (!deque.isEmpty()) {
            int len = deque.size();
            result.add(deque.peekLast().val);
            for (int i = 0; i < len; i++) {
                TreeNode polled = deque.pollLast();
                if (polled.right != null) {
                    deque.addFirst(polled.right);
                }
                if (polled.left != null) {
                    deque.addFirst(polled.left);
                }
            }
        }

        return result;
    }
}
