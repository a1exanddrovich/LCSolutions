package com.bliznichenka.trees.narytreepostordertraversal_590;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();

        Node root = getRoot();
        System.out.println(s.postorder(root));
    }

    private static Node getRoot() {
        List<Node> lastLevel = List.of(new Node(5), new Node(6));
        List<Node> middleLevel = List.of(new Node(3, lastLevel), new Node(2), new Node(4));

        return new Node(1, middleLevel);
    }
}
