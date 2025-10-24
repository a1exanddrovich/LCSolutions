package com.bliznichenka.run1.graphs.clonegraph_133;

import com.bliznichenka.run1.graphs.GraphUtils;
import com.bliznichenka.run1.graphs.Node;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();

        Node node = GraphUtils.getDefault();
        Node deepCopy = s.cloneGraph(node);
        System.out.println(deepCopy);
    }
}
