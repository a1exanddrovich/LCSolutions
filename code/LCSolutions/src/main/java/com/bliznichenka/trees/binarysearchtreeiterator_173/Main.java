package com.bliznichenka.trees.binarysearchtreeiterator_173;

import com.bliznichenka.trees.TreeNode;

public class Main {

    public static void main(String[] args) {
        TreeNode root = fromLeetcodeExample();
        
        BSTIterator bstIterator = new BSTIterator(root);
        System.out.println(bstIterator.next());    // return 3
        System.out.println(bstIterator.next());    // return 7
        System.out.println(bstIterator.hasNext()); // return True
        System.out.println(bstIterator.next());    // return 9
        System.out.println(bstIterator.hasNext()); // return True
        System.out.println(bstIterator.next());    // return 15
        System.out.println(bstIterator.hasNext()); // return True
        System.out.println(bstIterator.next());    // return 20
        System.out.println(bstIterator.hasNext()); // return False
    }

    private static TreeNode fromLeetcodeExample() {
        TreeNode left = new TreeNode(3);

        TreeNode rightLeft = new TreeNode(9);
        TreeNode rightRight = new TreeNode(20);

        TreeNode right = new TreeNode(15, rightLeft, rightRight);

        TreeNode root = new TreeNode(7, left, right);

        return root;
    }

}
