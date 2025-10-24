package com.bliznichenka.run1.linkedlist.findtheminimumandmaximumnumberofnodesbetweencriticalpoints_2058;

import com.bliznichenka.run1.linkedlist.ListNode;

public class Solution {
//    public int[] nodesBetweenCriticalPoints(ListNode head) {
//        List<Integer> criticalPoints = new ArrayList<>();
//
//        ListNode cur = head.next;
//        int index = 1;
//        int prevVal = head.val;
//        while (cur.next != null) {
//            int nextVal = cur.next.val;
//            int curVal = cur.val;
//
//            if ((curVal < prevVal && curVal < nextVal)
//                    || (curVal > prevVal && curVal > nextVal)) {
//                criticalPoints.add(index);
//            }
//
//            prevVal = curVal;
//            index++;
//            cur = cur.next;
//        }
//
//        if (criticalPoints.size() < 2) {
//            return new int[] {-1, -1};
//        }
//
//        int minDiff = Integer.MAX_VALUE;
//        for (int i = 1; i < criticalPoints.size(); i++) {
//            minDiff = Math.min(minDiff, criticalPoints.get(i) - criticalPoints.get(i - 1));
//        }
//
//        int maxDiff = criticalPoints.get(criticalPoints.size() - 1) - criticalPoints.get(0);
//
//        return new int[] {minDiff, maxDiff};
//    }

    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int count = 0;

        int minDiff = Integer.MAX_VALUE;

        int curIndex = 1;
        int firstCriticalPointIndex = Integer.MAX_VALUE;
        int lastCriticalPointIndex = Integer.MAX_VALUE;

        int prevVal = head.val;

        ListNode cur = head.next;

        while (cur.next != null) {
            int nextVal = cur.next.val;
            int curVal = cur.val;

            // if this is a critical point
            if ((curVal < prevVal && curVal < nextVal)
                    || (curVal > prevVal && curVal > nextVal)) {
                // if we already have at least one critical point then calculate the
                // minDiff
                if (count > 0) {
                    minDiff = Math.min(minDiff, curIndex - lastCriticalPointIndex);
                }
                lastCriticalPointIndex = curIndex;
                firstCriticalPointIndex = Math.min(firstCriticalPointIndex, curIndex);
                count++;
            }

            prevVal = curVal;
            curIndex++;
            cur = cur.next;
        }

        return count < 2
                ? new int[] {-1, -1}
                : new int[] {minDiff, lastCriticalPointIndex - firstCriticalPointIndex};
    }
}
