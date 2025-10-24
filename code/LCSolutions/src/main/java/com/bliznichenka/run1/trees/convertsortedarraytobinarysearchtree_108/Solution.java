package com.bliznichenka.run1.trees.convertsortedarraytobinarysearchtree_108;

import com.bliznichenka.run1.trees.TreeNode;

public class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return dfs(nums, 0, nums.length - 1);
    }

    private static TreeNode dfs(int[] nums, int l, int r) {
        if (l > r) {
            return null;
        }

        int m = l + (r - l) / 2;

        TreeNode node = new TreeNode(nums[m]);
        node.left = dfs(nums, l, m - 1);
        node.right = dfs(nums, m + 1, r);
        return node;
    }
}
