package com.bliznichenka.graphs.clonegraph_133;

import com.bliznichenka.graphs.Node;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        Map<Integer, Node> map = new HashMap<>();
        return dfs(node, map);
    }

    private static Node dfs(Node node, Map<Integer, Node> map) {
        if (map.containsKey(node.val)) {
            return map.get(node.val);
        }

        Node copied = new Node(node.val, new ArrayList<>());
        map.put(node.val, copied);

        for (Node neighbor : node.neighbors) {
            copied.neighbors.add(dfs(neighbor, map));
        }

        return copied;
    }
}
