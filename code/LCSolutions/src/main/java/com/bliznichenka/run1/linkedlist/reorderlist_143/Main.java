package com.bliznichenka.run1.linkedlist.reorderlist_143;

import com.bliznichenka.run1.linkedlist.ListNode;
import com.bliznichenka.run1.linkedlist.ListNodeUtils;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();

        ListNode list = ListNodeUtils.fromArray(1, 2, 3, 4, 5);
        s.reorderList(list);

        System.out.println(ListNodeUtils.toList(list));
    }
}
