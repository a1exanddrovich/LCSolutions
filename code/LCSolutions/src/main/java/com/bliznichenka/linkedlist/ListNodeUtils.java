package com.bliznichenka.linkedlist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * A class for common LinkedList operations
 */
public class ListNodeUtils {

    public static ListNode fromList(List<Integer> source) {
        ListNode head = new ListNode();

        ListNode currentNode = head;
        for (Integer val : source) {
            currentNode.next = new ListNode();
            currentNode = currentNode.next;
            currentNode.val = val;
        }

        return head.next;
    }

    public static ListNode fromArray(int... source) {
        return fromList(Arrays.stream(source).boxed().toList());
    }

    public static List<Integer> toList(ListNode source) {
        List<Integer> list = new ArrayList<>();

        while (source != null) {
            list.add(source.val);
            source = source.next;
        }

        return list;
    }

    public static void intersectAt(ListNode listA, ListNode listB, ListNode listC) {
        ListNode tailA = findTail(listA);
        ListNode tailB = findTail(listB);

        tailA.next = listC;
        tailB.next = listC;
    }

    public static void cycleAtPosition(ListNode head, int index) {
        ListNode tail = findTail(head);

        for (int i = 0; i < index; i++) {
            head = head.next;
        }

        tail.next = head;
    }

    public static ListNode selectNode(ListNode head, int content) {
        ListNode current = head;

        while (current != null) {
            if (current.val == content) {
                return current;
            }
            current = current.next;
        }

        return null;
    }

    private static ListNode findTail(ListNode list) {
        while (list.next != null) {
            list = list.next;
        }

        return list;
    }

}
