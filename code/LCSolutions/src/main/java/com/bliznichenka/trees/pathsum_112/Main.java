package com.bliznichenka.trees.pathsum_112;

import com.bliznichenka.trees.TreeNode;
import com.bliznichenka.trees.TreeNodeUtils;

public class Main {

    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode root1 = TreeNodeUtils.getDefault();

        System.out.println(s.hasPathSum(root1, 1));
    }

}
