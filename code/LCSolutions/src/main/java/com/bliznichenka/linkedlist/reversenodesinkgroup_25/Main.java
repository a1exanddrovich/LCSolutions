package com.bliznichenka.linkedlist.reversenodesinkgroup_25;

import com.bliznichenka.linkedlist.ListNode;
import com.bliznichenka.linkedlist.ListNodeUtils;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();

        ListNode list = ListNodeUtils.fromArray(1, 2, 3, 4, 5);
        int k = 2;
        ListNode listNode = s.reverseKGroup(list, k);

        System.out.println(ListNodeUtils.toList(listNode));
    }
}
