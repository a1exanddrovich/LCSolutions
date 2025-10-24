package com.bliznichenka.run1.linkedlist.removeduplicatesfromsortedlist_83;

import com.bliznichenka.run1.linkedlist.ListNode;
import com.bliznichenka.run1.linkedlist.ListNodeUtils;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        ListNode head = ListNodeUtils.fromList(List.of(1,1,2,3,3));

        System.out.println(ListNodeUtils.toList(s.deleteDuplicates(head)));
    }
}
