package com.bliznichenka.arraysandhashing.nextgreaterelementi_496;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            map.put(nums1[i], i);
        }

        int[] res = new int[nums1.length];
        // the stack is always in a decrease order.
        Stack<Integer> monotonicStack = new Stack<>();

        for (int curNum : nums2) {
            while (!monotonicStack.isEmpty() && monotonicStack.peek() < curNum) {
                int popped = monotonicStack.pop();
                int index = map.get(popped);
                res[index] = curNum;
            }

            if (map.containsKey(curNum)) {
                monotonicStack.push(curNum);
            }
        }

        while (!monotonicStack.isEmpty()) {
            int popped = monotonicStack.pop();
            int index = map.get(popped);
            res[index] = -1;
        }

        return res;
    }
}
