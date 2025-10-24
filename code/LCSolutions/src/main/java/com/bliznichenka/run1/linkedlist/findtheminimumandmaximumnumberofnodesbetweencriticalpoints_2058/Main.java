package com.bliznichenka.run1.linkedlist.findtheminimumandmaximumnumberofnodesbetweencriticalpoints_2058;

import com.bliznichenka.run1.linkedlist.ListNode;
import com.bliznichenka.run1.linkedlist.ListNodeUtils;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        ListNode head = ListNodeUtils.fromArray(5, 3, 1, 2, 5, 1, 2);
        System.out.println(Arrays.toString(s.nodesBetweenCriticalPoints(head)));
    }
}
