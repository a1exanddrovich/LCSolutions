package com.bliznichenka.run1.linkedlist.reverselinkedlist_206;

import com.bliznichenka.run1.linkedlist.ListNode;

public class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;

        while (current != null) {
            ListNode temp = current.next;
            current.next = prev;
            prev = current;
            current = temp;
        }

        return prev;
    }
}
