package com.bliznichenka.run1.trees.createbinarytreefromdescriptions_2196;

import com.bliznichenka.run1.trees.TreeNodeUtils;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[][] descriptions = {{20, 15, 1}, {20, 17, 0}, {50, 20, 1}, {50, 80, 0}, {80, 19, 1}};
        TreeNodeUtils.display(solution.createBinaryTree(descriptions));
    }
}
