package com.bliznichenka.linkedlist.mergenodesinbetweenzeros_2181;

import com.bliznichenka.linkedlist.ListNode;
import com.bliznichenka.linkedlist.ListNodeUtils;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        ListNode list = ListNodeUtils.fromArray(0, 3, 1, 0, 4, 5, 2, 0);
        System.out.println(ListNodeUtils.toList(solution.mergeNodes(list)));
    }
}
