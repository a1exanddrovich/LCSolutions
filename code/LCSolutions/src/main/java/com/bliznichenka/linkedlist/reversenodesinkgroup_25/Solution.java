package com.bliznichenka.linkedlist.reversenodesinkgroup_25;

import com.bliznichenka.linkedlist.ListNode;

public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        // making the dummy node to handle edge cases, like head.length == 1 and k == 1
        // and so on
        ListNode dummy = new ListNode();
        dummy.next = head;

        // left points to the first node that will be reversed
        ListNode left = dummy;
        // right's previous node will be the last one getting reversed
        ListNode right = head;

        int leftSteps = k;
        // this goes until the group to be reversed is found, or null is met
        while (leftSteps >= 0) {
            // in this case we found enough nodes to be reversed
            if (leftSteps == 0) {
                ListNode prev = null;
                ListNode cur = left.next;

                while (cur != right) {
                    ListNode temp = cur.next;
                    cur.next = prev;
                    prev = cur;
                    cur = temp;
                }

                ListNode newLeft = left.next;
                newLeft.next = right;
                left.next = prev;
                left = newLeft;
                leftSteps = k;
            }
            // in this case we got to the end of the list (doesn't matter whether the previous nodes were reversed)
            // for example if case like  [1, 2, 3, 4] and k = 2, we first perform the first condition adn then get to this
            // or in this [1, 2, 3, 4, 5] k = 2, we do the reverses two times and then for 5 we don't
            if (right == null) {
                return dummy.next;
            }
            right = right.next;
            leftSteps--;
        }

        return dummy.next;
    }
}
