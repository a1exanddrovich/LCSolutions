package com.bliznichenka.linkedlist.mergeksortedlists_23;

import com.bliznichenka.linkedlist.ListNode;
import com.bliznichenka.linkedlist.ListNodeUtils;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        ListNode[] lists = {
                ListNodeUtils.fromArray(1, 4, 5),
                ListNodeUtils.fromArray(1, 3, 4),
                ListNodeUtils.fromArray(2, 6)
        };

        ListNode result = solution.mergeKLists(lists);
        System.out.println(ListNodeUtils.toList(result));
    }
}
