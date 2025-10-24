package com.bliznichenka.run1.linkedlist.removelinkedlistelements_203;

import com.bliznichenka.run1.linkedlist.ListNode;

public class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode cur = head;
        ListNode prev = dummy;
        while (cur != null) {
            if (cur.val == val) {
                cur = cur.next;
                prev.next = cur;
            } else {
                prev = cur;
                cur = cur.next;
            }
        }

        return dummy.next;
    }
}
