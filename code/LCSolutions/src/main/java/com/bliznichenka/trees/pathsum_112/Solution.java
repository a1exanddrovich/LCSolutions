package com.bliznichenka.trees.pathsum_112;

import com.bliznichenka.trees.TreeNode;

public class Solution {

//    public boolean hasPathSum(TreeNode root, int targetSum) {
//        if (root == null) {
//            return false;
//        }
//        if (root.left == null && root.right == null && targetSum - root.val == 0) {
//            return true;
//        }
//        return hasPathSum(root.left, targetSum - root.val) ||
//               hasPathSum(root.right, targetSum - root.val);
//    }

    public boolean hasPathSum(TreeNode root, int targetSum) {
        return dfs(root, targetSum, 0);
    }

    private boolean dfs(TreeNode node, int targetSum, int currentSum) {
        if (node == null) {
            return false;
        }
        currentSum += node.val;
        if (node.left == null && node.right == null) {
            return currentSum == targetSum;
        }
        return dfs(node.left, targetSum, currentSum) || dfs(node.right, targetSum, currentSum);
    }

    private boolean path(TreeNode node, int target) {
        if (node.left == null && node.right == null) {
            return (target - node.val) == 0;
        } else if (node.left == null) {
            //this is a check if the sum is 0, and we have nodes to go
            //then it is false anyway, so no need to go further.
//            if (target - node.val == 0) {
//                return false;
//            }
            return path(node.right, target - node.val);
        } else if (node.right == null) {
//            if (target - node.val == 0) {
//                return false;
//            }
            return path(node.left, target - node.val);
        } else {
            return path(node.left, target - node.val)
                    || path(node.right, target - node.val);
        }
    }

}
