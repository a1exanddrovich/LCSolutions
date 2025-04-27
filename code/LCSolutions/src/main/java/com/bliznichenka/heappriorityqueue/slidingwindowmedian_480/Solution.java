package com.bliznichenka.heappriorityqueue.slidingwindowmedian_480;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {
    public double[] medianSlidingWindow(int[] nums, int k) {
        Queue<Integer> small = new PriorityQueue<>(Collections.reverseOrder());
        Queue<Integer> large = new PriorityQueue<>();
        Map<Integer, Integer> extraElements = new HashMap<>();

        for (int i = 0; i < k; i++) {
            small.add(nums[i]);
        }
        for (int i = 0; i < k / 2; i++) {
            large.add(small.poll());
        }

        double[] res = new double[nums.length - k + 1];
        res[0] = k % 2 == 1 ? small.peek() : (small.peek() + 0L + large.peek()) / 2.0;

        for (int i = k; i < nums.length; i++) {
            extraElements.put(nums[i - k], extraElements.getOrDefault(nums[i - k], 0) + 1);
            int balance = (!small.isEmpty() && nums[i - k] <= small.peek()) ? -1 : 1;

            if (nums[i] <= small.peek()) {
                small.add(nums[i]);
                balance++;
            } else {
                large.add(nums[i]);
                balance--;
            }

            if (balance > 0) {
                large.add(small.poll());
            }
            if (balance < 0) {
                small.add(large.poll());
            }

            while (!small.isEmpty() && extraElements.getOrDefault(small.peek(), 0) > 0) {
                extraElements.put(small.peek(), extraElements.get(small.peek()) - 1);
                small.poll();
            }
            while (!large.isEmpty() && extraElements.getOrDefault(large.peek(), 0) > 0) {
                extraElements.put(large.peek(), extraElements.get(large.peek()) - 1);
                large.poll();
            }
            res[i - k + 1] = k % 2 == 1 ? small.peek() : (small.peek() + 0L + large.peek()) / 2.0;
        }

        return res;
    }
}
