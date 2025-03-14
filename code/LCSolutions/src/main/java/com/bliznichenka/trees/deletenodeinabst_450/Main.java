package com.bliznichenka.trees.deletenodeinabst_450;

import com.bliznichenka.trees.TreeNode;
import com.bliznichenka.trees.TreeNodeUtils;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();

        TreeNode root = TreeNodeUtils.getFullDefaultBst();
        int key = 2;
        TreeNodeUtils.display(root);
        TreeNodeUtils.display(s.deleteNode(root, key));
    }
}
