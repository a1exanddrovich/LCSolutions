package com.bliznichenka.run1.trees.narytreepostordertraversal_590;

import java.util.List;

// Node class definition as per Leetcode
public class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int val) {
        this.val = val;
    }

    public Node(int val, List<Node> children) {
        this.val = val;
        this.children = children;
    }
}
