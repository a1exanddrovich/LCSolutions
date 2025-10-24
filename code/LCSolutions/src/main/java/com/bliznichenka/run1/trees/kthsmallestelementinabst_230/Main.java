package com.bliznichenka.run1.trees.kthsmallestelementinabst_230;

import com.bliznichenka.run1.trees.TreeNode;
import com.bliznichenka.run1.trees.TreeNodeUtils;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();

        TreeNode root = TreeNodeUtils.getFullDefaultBst();
        int k = 1;

        System.out.println(s.kthSmallest(root, k));
    }
}
