package com.bliznichenka.trees.constructbinarytreefrompreorderandinordertraversal_105;

import com.bliznichenka.trees.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inorderValToIndex = toMap(inorder);
        Deque<Integer> preorderDeque = toDeque(preorder);

        return dfs(preorderDeque, inorderValToIndex, 0, inorder.length - 1);
    }

    private static TreeNode dfs(Deque<Integer> preorderDeque,
                                Map<Integer, Integer> inorderValToIndex,
                                int left,
                                int right) {
        if (left > right) {
            return null;
        }

        int polled = preorderDeque.pollLast();
        TreeNode node = new TreeNode(polled);
        int mid = inorderValToIndex.get(polled);
        node.left = dfs(preorderDeque, inorderValToIndex, left, mid - 1);
        node.right = dfs(preorderDeque, inorderValToIndex, mid + 1, right);

        return node;
    }

    private static Map<Integer, Integer> toMap(int[] inorder) {
        Map<Integer, Integer> inorderValToIndex = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderValToIndex.put(inorder[i], i);
        }
        return inorderValToIndex;
    }

    private static Deque<Integer> toDeque(int[] preorder) {
        Deque<Integer> deque = new ArrayDeque<>();
        for (int val : preorder) {
            deque.addFirst(val);
        }
        return deque;
    }
}
