package com.bliznichenka.trees.maximumdepthofbinatytree_104;

import com.bliznichenka.trees.TreeNode;
import javafx.util.Pair;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class Solution {
//    public int maxDepth(TreeNode root) {
//        if (root == null) {
//            return 0;
//        }
//
//        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
//    }

    // dfs
//    public int maxDepth(TreeNode root) {
//        if (root == null) {
//            return 0;
//        }
//
//        int result = 0;
//
//        Stack<Pair<TreeNode, Integer>> stack = new Stack<>();
//        stack.push(new Pair<>(root, 1));
//
//        while (!stack.isEmpty()) {
//            var popped = stack.pop();
//            TreeNode cur = popped.getKey();
//            int depth = popped.getValue();
//
//            result = Math.max(result, depth);
//
//            if (cur.left != null) {
//                stack.push(new Pair<>(cur.left, depth + 1));
//            }
//            if (cur.right != null) {
//                stack.push(new Pair<>(cur.right, depth + 1));
//            }
//        }
//
//        return result;
//    }

    //bfs
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int result = 0;

        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.addLast(root);
        while (!deque.isEmpty()) {
            result++;
            int len = deque.size();

            while (len > 0) {
                TreeNode node = deque.pollFirst();
                if (node.left != null) {
                    deque.addLast(node.left);
                }
                if (node.right != null) {
                    deque.addLast(node.right);
                }
                len--;
            }
        }

        return result;
    }
}
