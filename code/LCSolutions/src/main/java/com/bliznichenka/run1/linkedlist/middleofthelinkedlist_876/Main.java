package com.bliznichenka.run1.linkedlist.middleofthelinkedlist_876;

import com.bliznichenka.run1.linkedlist.ListNode;
import com.bliznichenka.run1.linkedlist.ListNodeUtils;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        ListNode head = ListNodeUtils.fromList(List.of(1, 2, 3, 4));

        System.out.println(ListNodeUtils.toList(s.middleNode(head)));
    }
}
