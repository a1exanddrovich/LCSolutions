package com.bliznichenka.linkedlist.mergeksortedlists_23;

import com.bliznichenka.linkedlist.ListNode;

import java.util.*;

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

//    public ListNode mergeKLists(ListNode[] lists) {
//        List<ListNode> result = new ArrayList<>();
//
//        Collections.addAll(result, lists);
//
//        while (result.size() > 1) {
//            List<ListNode> merged = new ArrayList<>();
//
//            for (int i = 0; i < result.size(); i += 2) {
//                ListNode list1 = result.get(i);
//                ListNode list2 = i + 1 < result.size() ? result.get(i + 1) : null;
//                merged.add(merge(list1, list2));
//            }
//
//            result = merged;
//        }
//
//        return result.get(0);
//    }
//
//    private static ListNode merge(ListNode l1, ListNode l2) {
//        ListNode dummy = new ListNode();
//        ListNode cur = dummy;
//
//        while (l1 != null && l2 != null) {
//            if (l1.val < l2.val) {
//                cur.next = l1;
//                l1 = l1.next;
//            } else {
//                cur.next = l2;
//                l2 = l2.next;
//            }
//            cur = cur.next;
//        }
//
//        if (l1 != null) {
//            cur.next = l1;
//        }
//        if (l2 != null) {
//            cur.next = l2;
//        }
//
//        return dummy.next;
//    }
}
