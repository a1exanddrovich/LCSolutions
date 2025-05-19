package com.bliznichenka.trees.createbinarytreefromdescriptions_2196;

import com.bliznichenka.trees.TreeNode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {
    public TreeNode createBinaryTree(int[][] descriptions) {
        Map<Integer, TreeNode> map = new HashMap<>();
        Set<Integer> children = new HashSet<>();

        for (int[] description : descriptions) {
            int parentVal = description[0];
            int childVal = description[1];
            boolean isLeft = description[2] == 1;
            children.add(childVal);

            if (!map.containsKey(parentVal)) {
                map.put(parentVal, new TreeNode(parentVal));
            }
            if (!map.containsKey(childVal)) {
                map.put(childVal, new TreeNode(childVal));
            }

            TreeNode parent = map.get(parentVal);
            TreeNode child = map.get(childVal);

            if (isLeft) {
                parent.left = child;
            } else {
                parent.right = child;
            }
        }

        for (int[] description : descriptions) {
            if (!children.contains(description[0])) {
                return map.get(description[0]);
            }
        }

        return null;
    }
}
