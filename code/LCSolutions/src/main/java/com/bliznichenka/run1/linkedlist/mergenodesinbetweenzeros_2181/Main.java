package com.bliznichenka.run1.linkedlist.mergenodesinbetweenzeros_2181;

import com.bliznichenka.run1.linkedlist.ListNode;
import com.bliznichenka.run1.linkedlist.ListNodeUtils;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        ListNode list = ListNodeUtils.fromArray(0, 3, 1, 0, 4, 5, 2, 0);
        System.out.println(ListNodeUtils.toList(solution.mergeNodes(list)));
    }
}
