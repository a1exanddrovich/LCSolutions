package com.bliznichenka.linkedlist.mergeInbetweenlinkedlists_1669;

import com.bliznichenka.linkedlist.ListNode;
import com.bliznichenka.linkedlist.ListNodeUtils;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        ListNode list1 = ListNodeUtils.fromArray(10, 1, 13, 6, 9, 5);
        ListNode list2 = ListNodeUtils.fromArray(1000000, 1000001, 1000002);
        int a = 3;
        int b = 4;
        System.out.println(ListNodeUtils.toList(s.mergeInBetween(list1, a, b, list2)));
    }
}
