package com.bliznichenka.run1.linkedlist.intersectionsoftwolinkedlists_160;

import com.bliznichenka.run1.linkedlist.ListNode;
import com.bliznichenka.run1.linkedlist.ListNodeUtils;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        Solution s = new Solution();
        ListNode headA = ListNodeUtils.fromList(List.of(4, 1));
        ListNode headB = ListNodeUtils.fromList(List.of(5, 6, 1));
        ListNode headC = ListNodeUtils.fromList(List.of(8, 4, 5));
        ListNodeUtils.intersectAt(headA, headB, headC);

        System.out.println(ListNodeUtils.toList(s.getIntersectionNode(headA, headB)));
    }

}
