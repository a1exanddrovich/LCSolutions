package com.bliznichenka.run1.mathandgeometry.insertgreatestcommondivisorsinlinkedlist_2007;

import com.bliznichenka.run1.linkedlist.ListNode;
import com.bliznichenka.run1.linkedlist.ListNodeUtils;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        ListNode listNode = ListNodeUtils.fromArray(18, 6, 10, 3);
        System.out.println(solution.insertGreatestCommonDivisors(listNode));
    }
}
