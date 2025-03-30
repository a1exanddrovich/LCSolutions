package com.bliznichenka.heappriorityqueue.taskscheduler_621;


import javafx.util.Pair;

import java.util.*;

public class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> counter = new HashMap<>();
        for (char task : tasks) {
            counter.put(task, counter.getOrDefault(task, 0) + 1);
        }

        Queue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        for (int taskCount : counter.values()) {
            maxHeap.add(taskCount);
        }
        // [left tasks, time when get available]
        Deque<Pair<Integer, Integer>> deque = new ArrayDeque<>();

        int time = 0;
        while (!maxHeap.isEmpty() || !deque.isEmpty()) {
            time++;

            if (!maxHeap.isEmpty()) {
                int taskCount = maxHeap.poll();
                if (taskCount > 1) {
                    deque.addFirst(new Pair<>(taskCount - 1, time + n));
                }
            }

            if (!deque.isEmpty() && deque.peekLast().getValue() == time) {
                maxHeap.add(deque.pollLast().getKey());
            }
        }

        return time;
    }
}
