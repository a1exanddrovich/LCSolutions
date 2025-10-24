package com.bliznichenka.run1.trees.pathsum_112;

import com.bliznichenka.run1.trees.TreeNode;
import com.bliznichenka.run1.trees.TreeNodeUtils;

public class Main {

    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode root1 = TreeNodeUtils.getDefault();

        System.out.println(s.hasPathSum(root1, 1));
    }

}
