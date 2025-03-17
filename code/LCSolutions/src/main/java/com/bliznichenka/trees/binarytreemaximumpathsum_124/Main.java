package com.bliznichenka.trees.binarytreemaximumpathsum_124;

import com.bliznichenka.trees.TreeNode;
import com.bliznichenka.trees.TreeNodeUtils;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        TreeNode root = TreeNodeUtils.deserializePreorder("3 -4 1 X X 20 X X 10 -1 X X 5 X X");
        System.out.println(solution.maxPathSum(root));
    }
}
