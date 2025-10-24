package com.bliznichenka.run1.linkedlist.linkedlistcycle_141;

import com.bliznichenka.run1.linkedlist.ListNode;
import com.bliznichenka.run1.linkedlist.ListNodeUtils;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();

        ListNode list = ListNodeUtils.fromArray(1, 3, 10, 11);
        ListNodeUtils.cycleAtPosition(list, 1);

        System.out.println(s.hasCycle(list));
    }
}
