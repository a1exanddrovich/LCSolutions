package com.bliznichenka.trees.deleteleaveswithagivenvalue_1325;

import com.bliznichenka.trees.TreeNode;

public class Solution {
    public TreeNode removeLeafNodes(TreeNode node, int target) {
        if (node == null) {
            return null;
        }

        node.left = removeLeafNodes(node.left, target);
        node.right = removeLeafNodes(node.right, target);

        if (node.left == null && node.right == null && node.val == target) {
            return null;
        }

        return node;
    }

//    public TreeNode removeLeafNodes(TreeNode root, int target) {
//        Stack<TreeNode> stack = new Stack<>();
//        Set<TreeNode> visited = new HashSet<>();
//        Map<TreeNode, TreeNode> parents = new HashMap<>();
//
//        stack.push(root);
//        parents.put(root, null);
//
//        while (!stack.isEmpty()) {
//            TreeNode popped = stack.pop();
//            if (popped.left == null && popped.right == null) {
//                if (popped.val == target) {
//                    TreeNode parent = parents.get(popped);
//                    if (parent == null) {
//                        return null;
//                    }
//
//                    if (parent.left == popped) {
//                        parent.left = null;
//                    }
//                    if (parent.right == popped) {
//                        parent.right = null;
//                    }
//                }
//            } else if (!visited.contains(popped)) {
//                visited.add(popped);
//                stack.push(popped);
//                if (popped.right != null) {
//                    stack.push(popped.right);
//                    parents.put(popped.right, popped);
//                }
//                if (popped.left != null) {
//                    stack.push(popped.left);
//                    parents.put(popped.left, popped);
//                }
//            }
//        }
//
//        return root;
//    }
}
