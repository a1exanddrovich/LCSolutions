package com.bliznichenka.linkedlist.addtwonumbers_2;

import com.bliznichenka.linkedlist.ListNode;
import com.bliznichenka.linkedlist.ListNodeUtils;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();

        ListNode l1 = ListNodeUtils.fromArray(9, 9, 9, 9, 9, 9, 9);
        ListNode l2 = ListNodeUtils.fromArray(9, 9, 9, 9);

        System.out.println(ListNodeUtils.toList(s.addTwoNumbers(l1, l2)));
    }
}
