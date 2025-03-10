package com.bliznichenka.linkedlist.mergeksortedlists_23;

import com.bliznichenka.linkedlist.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        Queue<ListNode> minHeap = new PriorityQueue<>(
                Comparator.comparingInt(node -> node.val)
        );

        for (ListNode list : lists) {
            if (list != null) {
                minHeap.add(list);
            }
        }

        ListNode dummy = new ListNode();
        ListNode cur = dummy;
        while (!minHeap.isEmpty()) {
            ListNode node = minHeap.poll();

            if (node.next != null) {
                minHeap.add(node.next);
            }

            cur.next = node;
            cur = cur.next;
        }

        return dummy.next;
    }
}
