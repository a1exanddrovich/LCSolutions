package com.bliznichenka.run1.trees.houserobberiii_337;

import com.bliznichenka.run1.trees.TreeNode;
import javafx.util.Pair;

public class Solution {
    public int rob(TreeNode root) {
        Pair<Integer, Integer> pair = dfs(root);
        return Math.max(pair.getKey(), pair.getValue());
    }

    private static Pair<Integer, Integer> dfs(TreeNode node) {
        if (node == null) {
            return new Pair<>(0, 0);
        }

        Pair<Integer, Integer> leftPair = dfs(node.left);
        Pair<Integer, Integer> rightPair = dfs(node.right);

        int notRobbed = Math.max(leftPair.getKey(), leftPair.getValue())
                + Math.max(rightPair.getKey(), rightPair.getValue());
        int robbed = node.val + leftPair.getKey() + rightPair.getKey();

        return new Pair<>(notRobbed, robbed);
    }
}
