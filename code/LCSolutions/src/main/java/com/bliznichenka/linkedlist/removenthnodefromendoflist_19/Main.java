package com.bliznichenka.linkedlist.removenthnodefromendoflist_19;

import com.bliznichenka.linkedlist.ListNode;
import com.bliznichenka.linkedlist.ListNodeUtils;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();

        ListNode list = ListNodeUtils.fromArray(1, 2, 3, 4, 5);
        int n = 2;
        ListNode result = s.removeNthFromEnd(list, n);

        System.out.println(ListNodeUtils.toList(result));
    }
}
