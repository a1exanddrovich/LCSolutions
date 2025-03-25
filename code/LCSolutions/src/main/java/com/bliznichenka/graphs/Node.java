package com.bliznichenka.graphs;

import java.util.ArrayList;
import java.util.List;

// Node definition as per Leetcode.
public class Node {
    public final int val;
    public final List<Node> neighbors;

    public Node() {
        val = 0;
        neighbors = new ArrayList<>();
    }

    public Node(int val) {
        this.val = val;
        neighbors = new ArrayList<>();
    }

    public Node(int val, List<Node> neighbors) {
        this.val = val;
        this.neighbors = neighbors;
    }

    // the below method are not supported on Leetcode.
    public void addAllNeighbors(List<Node> neighbors) {
        this.neighbors.addAll(neighbors);
    }
}
