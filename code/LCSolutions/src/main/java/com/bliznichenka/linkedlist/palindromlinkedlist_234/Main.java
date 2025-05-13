package com.bliznichenka.linkedlist.palindromlinkedlist_234;

import com.bliznichenka.linkedlist.ListNode;
import com.bliznichenka.linkedlist.ListNodeUtils;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        ListNode head = ListNodeUtils.fromList(List.of(1, 2, 2, 1));

        System.out.println(s.isPalindrome(head));
    }
}
