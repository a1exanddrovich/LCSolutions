package com.bliznichenka.run1.linkedlist.mergeInbetweenlinkedlists_1669;

import com.bliznichenka.run1.linkedlist.ListNode;

public class Solution {
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode i = list1;
        int index = 0;
        while (index != a - 1) {
            i = i.next;
            index++;
        }

        ListNode nextI = i.next;
        i.next = list2;
        i = nextI;
        index++;

        while (list2.next != null) {
            list2 = list2.next;
        }

        while (index != b + 1) {
            i = i.next;
            index++;
        }

        list2.next = i;

        return list1;
    }
}
