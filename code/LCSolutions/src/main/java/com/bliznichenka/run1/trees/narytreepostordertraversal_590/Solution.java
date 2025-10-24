package com.bliznichenka.run1.trees.narytreepostordertraversal_590;

import javafx.util.Pair;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Solution {
    public List<Integer> postorder(Node root) {
        List<Integer> result = new ArrayList<>();
        Deque<Pair<Node, Boolean>> stack = new ArrayDeque<>();

        stack.addFirst(new Pair<>(root, false));
        while (!stack.isEmpty()) {
            Pair<Node, Boolean> popped = stack.removeFirst();
            Node node = popped.getKey();
            boolean visited = popped.getValue();
            if (node != null) {
                if (visited) {
                    result.add(node.val);
                } else {
                    stack.addFirst(new Pair<>(node, true));
                    if (node.children != null) {
                        for (int i = node.children.size() - 1; i >= 0; i--) {
                            stack.addFirst(new Pair<>(node.children.get(i), false));
                        }
                    }
                }
            }
        }

        return result;
    }

//    public List<Integer> postorder(Node root) {
//        if (root == null) {
//            return List.of();
//        }
//
//        List<Integer> result = new ArrayList<>();
//
//        for (Node child : root.children) {
//            result.addAll(postorder(child));
//        }
//        result.add(root.val);
//
//        return result;
//    }
}
