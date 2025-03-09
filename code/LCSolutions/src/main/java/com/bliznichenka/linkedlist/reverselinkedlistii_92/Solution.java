package com.bliznichenka.linkedlist.reverselinkedlistii_92;

import com.bliznichenka.linkedlist.ListNode;

public class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode();
        dummy.next = head;

        int index = 1;
        ListNode leftNode = dummy;
        ListNode cur = head;
        while (index < left) {
            index++;
            leftNode = cur;
            cur = cur.next;
        }

        ListNode prev = cur;
        cur = cur.next;
        while (index < right) {
            index++;
            ListNode temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
        }

        leftNode.next.next = cur;
        leftNode.next = prev;

        return dummy.next;
    }
}
