package com.bliznichenka.linkedlist.middleofthelinkedlist_876;

import com.bliznichenka.linkedlist.ListNode;

public class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
}
