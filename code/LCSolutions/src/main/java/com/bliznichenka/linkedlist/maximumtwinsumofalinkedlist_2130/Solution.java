package com.bliznichenka.linkedlist.maximumtwinsumofalinkedlist_2130;

import com.bliznichenka.linkedlist.ListNode;

public class Solution {
    public int pairSum(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            ListNode next = slow.next;
            slow.next = prev;
            prev = slow;
            slow = next;
        }

        int max = 0;
        while (slow != null) {
            max = Math.max(max, prev.val + slow.val);
            prev = prev.next;
            slow = slow.next;
        }

        return max;
    }
}
