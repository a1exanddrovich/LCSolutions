package com.bliznichenka.trees.constructquadtree_427;

public class Solution {
    public Node construct(int[][] grid) {
        return dfs(grid, 0, 0, grid.length);
    }

    private static Node dfs(int[][] grid, int topRow, int topCol, int n) {
        Node node = new Node();

        if (areAllEqual(grid, topRow, topCol, n)) {
            node.isLeaf = true;
            node.val = grid[topRow][topCol] == 1;
        } else {
            int newN = n / 2;
            node.topLeft = dfs(grid, topRow, topCol, newN);
            node.topRight = dfs(grid, topRow, topCol + newN, newN);
            node.bottomLeft = dfs(grid, topRow + newN, topCol, newN);
            node.bottomRight = dfs(grid, topRow + newN, topCol + newN, newN);
        }

        return node;
    }

    private static boolean areAllEqual(int[][] grid, int topRow, int topCol, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[topRow][topCol] != grid[topRow + i][topCol + j]) {
                    return false;
                }
            }
        }

        return true;
    }
}
