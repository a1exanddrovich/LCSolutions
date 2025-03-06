package com.bliznichenka.linkedlist.copylistwithrandompointer_138;

import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();

        Node head = buildData();

        printData(head);
        System.out.println("---------------");
        printData(s.copyRandomList(head));
    }

    // https://leetcode.com/problems/copy-list-with-random-pointer/description/
    // The data is from the first example.
    private static Node buildData() {
        Node zero = new Node(7);
        Node one = new Node(13);
        Node two = new Node(11);
        Node three = new Node(10);
        Node four = new Node(1);

        zero.next = one;
        zero.random = null;

        one.next = two;
        one.random = zero;

        two.next = three;
        two.random = four;

        three.next = four;
        three.random = two;

        four.next = null;
        four.random = zero;

        return zero;
    }

    private static void printData(Node head) {
        while (head != null) {
            System.out.println("[" +
                    head.val +
                    ", " +
                    (Objects.nonNull(head.random) ? head.random.val : "null")
                    + "]");
            head = head.next;
        }
    }
}
