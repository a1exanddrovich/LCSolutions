package com.bliznichenka.run1.trees.serializeanddeserializebinarytree_297;

import com.bliznichenka.run1.trees.TreeNode;
import com.bliznichenka.run1.trees.TreeNodeUtils;

public class Main {
    public static void main(String[] args) {
        Codec codec = new Codec();

        TreeNode root = TreeNodeUtils.deserializePreorder("2 3 1 X X 10 X X 4 X X");

        TreeNodeUtils.display(codec.deserialize(codec.serialize(root)));
    }
}
