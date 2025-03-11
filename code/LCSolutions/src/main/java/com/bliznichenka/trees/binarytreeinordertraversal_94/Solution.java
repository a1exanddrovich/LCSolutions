package com.bliznichenka.trees.binarytreeinordertraversal_94;

import com.bliznichenka.trees.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        dfs(root, result);
        return result;
    }

    private static void dfs(TreeNode node, List<Integer> result) {
        if (node == null) {
            return;
        }

        dfs(node.left, result);
        result.add(node.val);
        dfs(node.right, result);
    }
}
