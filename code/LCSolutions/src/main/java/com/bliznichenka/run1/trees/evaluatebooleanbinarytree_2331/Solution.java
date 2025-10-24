package com.bliznichenka.run1.trees.evaluatebooleanbinarytree_2331;

import com.bliznichenka.run1.trees.TreeNode;

public class Solution {
    public boolean evaluateTree(TreeNode root) {
        if (root.left == null && root.right == null) {
            return root.val == 1;
        }

        if (root.val == 2) {
            return evaluateTree(root.left) || evaluateTree(root.right);
        } else {
            return evaluateTree(root.left) && evaluateTree(root.right);
        }
    }

    // iterative approach
//    public boolean evaluateTree(TreeNode root) {
//        Map<TreeNode, Boolean> map = new HashMap<>();
//        Stack<TreeNode> stack = new Stack<>();
//
//        stack.push(root);
//        while (!stack.isEmpty()) {
//            TreeNode node = stack.pop();
//            if (node.left == null && node.right == null) {
//                map.put(node, node.val == 1);
//            } else if (map.containsKey(node.left) && map.containsKey(node.right)) {
//                if (node.val == 2) {
//                    map.put(node, map.get(node.left) || map.get(node.right));
//                } else {
//                    map.put(node, map.get(node.left) && map.get(node.right));
//                }
//            } else {
//                stack.push(node);
//                stack.push(node.left);
//                stack.push(node.right);
//            }
//        }
//
//        return map.get(root);
//    }
}
