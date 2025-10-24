package com.bliznichenka.run1.linkedlist.palindromlinkedlist_234;

import com.bliznichenka.run1.linkedlist.ListNode;

public class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode prev = null;
        ListNode cur = slow;
        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
        }

        ListNode l = head;
        ListNode r = prev;

        while (l != null && r != null) {
            if (l.val != r.val) {
                return false;
            }
            l = l.next;
            r = r.next;
        }

        return true;
    }
}
