package com.bliznichenka.run1.linkedlist.palindromlinkedlist_234;

import com.bliznichenka.run1.linkedlist.ListNode;
import com.bliznichenka.run1.linkedlist.ListNodeUtils;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        ListNode head = ListNodeUtils.fromList(List.of(1, 2, 2, 1));

        System.out.println(s.isPalindrome(head));
    }
}
