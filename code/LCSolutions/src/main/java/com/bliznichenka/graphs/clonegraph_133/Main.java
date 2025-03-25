package com.bliznichenka.graphs.clonegraph_133;

import com.bliznichenka.graphs.GraphUtils;
import com.bliznichenka.graphs.Node;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();

        Node node = GraphUtils.getDefault();
        Node deepCopy = s.cloneGraph(node);
        System.out.println(deepCopy);
    }
}
