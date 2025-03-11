package com.bliznichenka.trees.binarytreepostordertraversal_145;

import com.bliznichenka.trees.TreeNode;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<Pair<TreeNode, Boolean>> stack = new Stack<>();

        stack.push(new Pair<>(root, false));
        while (!stack.isEmpty()) {
            var popped = stack.pop();
            TreeNode cur = popped.getKey();
            boolean visited = popped.getValue();

            if (cur != null) {
                if (visited) {
                    result.add(cur.val);
                } else {
                    stack.push(new Pair<>(cur, true));
                    stack.push(new Pair<>(cur.right, false));
                    stack.push(new Pair<>(cur.left, false));
                }
            }
        }

        return result;
    }

//    public List<Integer> postorderTraversal(TreeNode root) {
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
//        dfs(node.left, result);
//        dfs(node.right, result);
//        result.add(node.val);
//    }
}
