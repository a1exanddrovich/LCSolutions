package com.bliznichenka.run1.linkedlist.removenthnodefromendoflist_19;

import com.bliznichenka.run1.linkedlist.ListNode;
import com.bliznichenka.run1.linkedlist.ListNodeUtils;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();

        ListNode list = ListNodeUtils.fromArray(1, 2, 3, 4, 5);
        int n = 2;
        ListNode result = s.removeNthFromEnd(list, n);

        System.out.println(ListNodeUtils.toList(result));
    }
}
