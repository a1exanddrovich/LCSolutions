package com.bliznichenka.run1.trees.leafsimilartrees_872;

import com.bliznichenka.run1.trees.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    // bfs won't work out as leaf nodes can be at different levels.
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> sequence1 = new ArrayList<>();
        List<Integer> sequence2 = new ArrayList<>();

        fillLeafValueSequence(root1, sequence1);
        fillLeafValueSequence(root2, sequence2);

        return sequence1.equals(sequence2);
    }

    private void fillLeafValueSequence(TreeNode node, List<Integer> sequence) {
        if (node == null) {
            return;
        }
        if (node.left == null && node.right == null) {
            sequence.add(node.val);
            return;
        }

        fillLeafValueSequence(node.left, sequence);
        fillLeafValueSequence(node.right, sequence);
    }
}
