package com.bliznichenka.trees.kthsmallestelementinabst_230;

import com.bliznichenka.trees.TreeNode;
import com.bliznichenka.trees.TreeNodeUtils;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();

        TreeNode root = TreeNodeUtils.getFullDefaultBst();
        int k = 1;

        System.out.println(s.kthSmallest(root, k));
    }
}
