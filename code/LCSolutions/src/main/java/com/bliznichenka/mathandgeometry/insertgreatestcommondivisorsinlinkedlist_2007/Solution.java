package com.bliznichenka.mathandgeometry.insertgreatestcommondivisorsinlinkedlist_2007;

import com.bliznichenka.linkedlist.ListNode;

public class Solution {
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        ListNode cur = head;
        while (cur.next != null) {
            ListNode divisor = new ListNode(gcd(cur.val, cur.next.val));
            divisor.next = cur.next;
            cur.next = divisor;
            cur = cur.next.next;
        }
        return head;
    }

    private static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}
