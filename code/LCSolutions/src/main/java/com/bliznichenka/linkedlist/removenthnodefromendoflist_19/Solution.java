package com.bliznichenka.linkedlist.removenthnodefromendoflist_19;

import com.bliznichenka.linkedlist.ListNode;

public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode();
        dummy.next = head;

        ListNode first = dummy;
        ListNode second = head;
        while (n > 0) {
            second = second.next;
            n--;
        }

        while (second != null) {
            second = second.next;
            first = first.next;
        }

        first.next = first.next.next;

        return dummy.next;
    }
}
