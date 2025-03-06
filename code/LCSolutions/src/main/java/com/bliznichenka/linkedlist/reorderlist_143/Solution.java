package com.bliznichenka.linkedlist.reorderlist_143;

import com.bliznichenka.linkedlist.ListNode;

public class Solution {
    public void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode prev = null;
        ListNode cur = slow;

        while (cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }

        ListNode l = head;
        ListNode r = prev;

        while (l != r) {
            ListNode nextL = l.next;
            l.next = r;
            l = nextL;
            if (l != r) {
                ListNode nextR = r.next;
                r.next = l;
                r = nextR;
            }
        }
    }
}
