package com.bliznichenka.linkedlist.mergetwosortedlists_21;

import com.bliznichenka.linkedlist.ListNode;
import com.bliznichenka.linkedlist.ListNodeUtils;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();

        ListNode list1 = ListNodeUtils.fromArray(1, 3, 10);
        ListNode list2 = ListNodeUtils.fromArray(1, 2, 9, 40);
        ListNode listNode = s.mergeTwoLists(list1, list2);

        System.out.println(ListNodeUtils.toList(listNode));
    }
}
