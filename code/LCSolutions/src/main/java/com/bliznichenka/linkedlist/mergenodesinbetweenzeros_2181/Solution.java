package com.bliznichenka.linkedlist.mergenodesinbetweenzeros_2181;

import com.bliznichenka.linkedlist.ListNode;

public class Solution {
    // kinda in-place solution
    public ListNode mergeNodes(ListNode head) {
        ListNode lastNode = head;
        ListNode cur = head.next.next;

        while (cur != null) {
            if (cur.val == 0) {
                lastNode = lastNode.next;
                lastNode.next.val = 0;
            } else {
                lastNode.next.val += cur.val;
            }
            cur = cur.next;
        }
        lastNode.next = null;

        return head.next;
    }

    // with creating of a new list
//    public ListNode mergeNodes(ListNode head) {
//        ListNode newHead = new ListNode(-1);
//        ListNode curNew = newHead;
//        ListNode cur = head.next;
//        int sum = 0;
//
//        while (cur != null) {
//            if (cur.val != 0) {
//                sum += cur.val;
//            } else {
//                curNew.next = new ListNode(sum);
//                curNew = curNew.next;
//                sum = 0;
//            }
//            cur = cur.next;
//        }
//
//        return newHead.next;
//    }
}
