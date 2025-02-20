package com.bliznichenka.slidingwindow.slidingwindowmaximum_239;

import java.util.*;

public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        List<Integer> result = new ArrayList<>();

        // indices
        Deque<Integer> deque = new ArrayDeque<>();

        int l = 0;
        int r = 0;
        while (r < nums.length) {
            // add right
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[r]) {
                deque.pollLast();
            }
            deque.addLast(r);

            // remove left
            if (l > deque.peekFirst()) {
                deque.pollFirst();
            }

            if (r + 1 >= k) {
                result.add(nums[deque.peekFirst()]);
                l++;
            }
            r++;
        }

        int[] arrResult = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            arrResult[i] = result.get(i);
        }
        return arrResult;
    }
}
