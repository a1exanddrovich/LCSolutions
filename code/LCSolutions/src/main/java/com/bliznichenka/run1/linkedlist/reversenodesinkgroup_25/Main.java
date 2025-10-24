package com.bliznichenka.run1.linkedlist.reversenodesinkgroup_25;

import com.bliznichenka.run1.linkedlist.ListNode;
import com.bliznichenka.run1.linkedlist.ListNodeUtils;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();

        ListNode list = ListNodeUtils.fromArray(1, 2, 3, 4, 5);
        int k = 2;
        ListNode listNode = s.reverseKGroup(list, k);

        System.out.println(ListNodeUtils.toList(listNode));
    }
}
