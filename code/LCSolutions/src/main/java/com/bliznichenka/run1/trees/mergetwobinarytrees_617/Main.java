package com.bliznichenka.run1.trees.mergetwobinarytrees_617;

import com.bliznichenka.run1.trees.TreeNode;
import com.bliznichenka.run1.trees.TreeNodeUtils;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode root1 = TreeNodeUtils.getDefault();
        TreeNode root2 = TreeNodeUtils.getDefaultWithNullifiedRight();

        System.out.println(s.mergeTrees(root1, root2));
    }
}
