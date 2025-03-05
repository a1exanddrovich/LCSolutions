package com.bliznichenka.linkedlist.reverselinkedlist_206;

import com.bliznichenka.linkedlist.ListNode;
import com.bliznichenka.linkedlist.ListNodeUtils;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        Solution s = new Solution();

        ListNode list = ListNodeUtils.fromArray(1, 2, 3, 4);
        ListNode listNode = s.reverseList(list);

        System.out.println(ListNodeUtils.toList(listNode));
    }

}
