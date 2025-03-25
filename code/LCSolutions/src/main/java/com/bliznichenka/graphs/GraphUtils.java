package com.bliznichenka.graphs;

import java.util.List;

public class GraphUtils {
    public static Node getDefault() {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);

        node1.addAllNeighbors(List.of(node2, node4));
        node2.addAllNeighbors(List.of(node1, node3));
        node3.addAllNeighbors(List.of(node2, node4));
        node4.addAllNeighbors(List.of(node1, node3));

        return node1;
    }
}
