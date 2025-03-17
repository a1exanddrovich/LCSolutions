package com.bliznichenka.trees.serializeanddeserializebinarytree_297;

import com.bliznichenka.trees.TreeNode;

import java.util.*;

public class Codec {
    public String serialize(TreeNode root) {
        List<String> nodes = new ArrayList<>();
        dfsSerialize(root, nodes);
        return String.join(" ", nodes);
    }

    public TreeNode deserialize(String data) {
        Iterator<String> iterator = Arrays.stream(data.split(" ")).iterator();
        return dfsDeserialize(iterator);
    }

    private static void dfsSerialize(TreeNode node, List<String> nodes) {
        if (node == null) {
            nodes.add("N");
            return;
        }

        nodes.add(Integer.toString(node.val));
        dfsSerialize(node.left, nodes);
        dfsSerialize(node.right, nodes);
    }

    private static TreeNode dfsDeserialize(Iterator<String> iterator) {
        String nodeVal = iterator.next();

        if (nodeVal.equals("N")) {
            return null;
        }

        TreeNode node = new TreeNode(Integer.parseInt(nodeVal));
        node.left = dfsDeserialize(iterator);
        node.right = dfsDeserialize(iterator);

        return node;
    }
}

