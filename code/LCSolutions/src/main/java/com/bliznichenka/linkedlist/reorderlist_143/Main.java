package com.bliznichenka.linkedlist.reorderlist_143;

import com.bliznichenka.linkedlist.ListNode;
import com.bliznichenka.linkedlist.ListNodeUtils;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();

        ListNode list = ListNodeUtils.fromArray(1, 2, 3, 4, 5);
        s.reorderList(list);

        System.out.println(ListNodeUtils.toList(list));
    }
}
