package com.bliznichenka.linkedlist.reverselinkedlistii_92;

import com.bliznichenka.linkedlist.ListNode;
import com.bliznichenka.linkedlist.ListNodeUtils;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();

        ListNode list = ListNodeUtils.fromArray(1, 3, 5, 6, 7, 8);
        int left = 2;
        int right = 5;

        ListNode listNode = s.reverseBetween(list, left, right);

        System.out.println(ListNodeUtils.toList(listNode));
    }
}
