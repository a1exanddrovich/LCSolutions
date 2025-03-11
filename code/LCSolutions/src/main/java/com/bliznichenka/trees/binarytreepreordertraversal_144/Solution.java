package com.bliznichenka.trees.binarytreepreordertraversal_144;

import com.bliznichenka.trees.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                result.add(cur.val);
                stack.push(cur.right);
                cur = cur.left;
            }

            cur = stack.pop();
        }

        return result;
    }

//    public List<Integer> preorderTraversal(TreeNode root) {
//        List<Integer> result = new ArrayList<>();
//        dfs(root, result);
//        return result;
//    }
//
//    private static void dfs(TreeNode node, List<Integer> result) {
//        if (node == null) {
//            return;
//        }
//
//        result.add(node.val);
//        dfs(node.left, result);
//        dfs(node.right, result);
//    }
}
