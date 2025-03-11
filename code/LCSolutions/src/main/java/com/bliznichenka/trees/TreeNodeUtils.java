package com.bliznichenka.trees;

import java.util.Arrays;
import java.util.Iterator;

public class TreeNodeUtils {
    public static final String SERIALIZATION_DELIMITER = " ";
    public static final String SERIALIZATION_NULL_NODE_MARK = "X";

    public static TreeNode getDefault() {
        TreeNode leftLeft = new TreeNode(3);
        TreeNode leftRight = new TreeNode(4);

        TreeNode rightLeft = new TreeNode(6);
        TreeNode rightRight = new TreeNode(7);

        TreeNode left = new TreeNode(2, leftLeft, leftRight);
        TreeNode right = new TreeNode(5, rightLeft, rightRight);

        TreeNode root = new TreeNode(1, left, right);

        return root;
    }

    public static TreeNode getFlipEquivalentToDefault() {
        TreeNode leftLeft = new TreeNode(7);
        TreeNode leftRight = new TreeNode(6);

        TreeNode rightLeft = new TreeNode(4);
        TreeNode rightRight = new TreeNode(3);

        TreeNode left = new TreeNode(5, leftLeft, leftRight);
        TreeNode right = new TreeNode(2, rightLeft, rightRight);

        TreeNode root = new TreeNode(1, left, right);

        return root;
    }

    public static TreeNode getDefaultBst() {
        TreeNode leftLeft = new TreeNode(1);
        TreeNode leftRight = new TreeNode(3);

        TreeNode left = new TreeNode(2, leftLeft, leftRight);
        TreeNode right = new TreeNode(6, null, null);

        TreeNode root = new TreeNode(4, left, right);

        return root;
    }

    public static TreeNode getFullDefaultBst() {
        TreeNode leftLeft = new TreeNode(1);
        TreeNode leftRight = new TreeNode(3);

        TreeNode rightLeft = new TreeNode(5);
        TreeNode rightRight = new TreeNode(9);

        TreeNode left = new TreeNode(2, leftLeft, leftRight);
        TreeNode right = new TreeNode(6, rightLeft, rightRight);

        TreeNode root = new TreeNode(4, left, right);

        return root;
    }


    public static TreeNode getDefaultMirrored() {
        TreeNode leftLeft = new TreeNode(3);
        TreeNode leftRight = new TreeNode(4);

        TreeNode rightLeft = new TreeNode(4);
        TreeNode rightRight = new TreeNode(3);

        TreeNode left = new TreeNode(2, leftLeft, leftRight);
        TreeNode right = new TreeNode(2, rightLeft, rightRight);

        TreeNode root = new TreeNode(1, left, right);

        return root;
    }

    public static TreeNode getTreeWithDuplicateSubtrees() {
        TreeNode leftLeft = new TreeNode(4);

        TreeNode rightLeft = new TreeNode(2);
        rightLeft.left = new TreeNode(4);

        TreeNode rightRight = new TreeNode(4);

        TreeNode left = new TreeNode(2, leftLeft, null);
        TreeNode right = new TreeNode(3, rightLeft, rightRight);

        TreeNode root = new TreeNode(1, left, right);

        return root;
    }

    public static TreeNode getDefaultSubtree() {
        TreeNode leftLeft = new TreeNode(3);
        TreeNode leftRight = new TreeNode(4);

        TreeNode left = new TreeNode(2, leftLeft, leftRight);

        return left;
    }

    public static TreeNode getDefaultWithNullifiedLeft() {
        TreeNode root = getDefault();
        root.left = null;

        return root;
    }

    public static TreeNode getDefaultWithNullifiedRight() {
        TreeNode root = getDefault();
        root.right = null;

        return root;
    }

    public static void display(TreeNode root) {
        printTree(root, 0);
    }

    public static TreeNode deserializePreorder(String... args) {
        if (args.length < 1) {
            throw new RuntimeException("No data passed.");
        }

        String source = args[0];
        String delimiter = args.length >= 2 ? args[1] : SERIALIZATION_DELIMITER;
        String nullNode = args.length >= 3 ? args[2] : SERIALIZATION_NULL_NODE_MARK;
        Iterator<String> iterator = Arrays.stream(source.split(delimiter)).iterator();

        return parseSource(iterator, nullNode);
    }

    private static TreeNode parseSource(Iterator<String> source, String nullNode) {
        String nextVal = source.next();

        if (nextVal.equals(nullNode)) {
            return null;
        }

        TreeNode node = new TreeNode(Integer.parseInt(nextVal));

        node.left = parseSource(source, nullNode);
        node.right = parseSource(source, nullNode);

        return node;
    }

    private static void printTree(TreeNode root, int level) {
        if (root == null) {
            return;
        }

        for (int i = 0; i < level; i++) {
            System.out.print("  ");
        }

        System.out.println(root.val);

        printTree(root.left, level + 1);
        printTree(root.right, level + 1);
    }

}
