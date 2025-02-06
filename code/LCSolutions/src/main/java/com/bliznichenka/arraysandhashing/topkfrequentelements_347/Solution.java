package com.bliznichenka.arraysandhashing.topkfrequentelements_347;

import java.util.*;

public class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> counter = new HashMap<>();

        for (int num : nums) {
            counter.put(num, counter.getOrDefault(num, 0) + 1);
        }

        Queue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>(
                Comparator.comparingInt(Map.Entry::getValue)
        );

        for (Map.Entry<Integer, Integer> entry : counter.entrySet()) {
            minHeap.add(entry);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        int[] result = new int[minHeap.size()];
        int i = 0;

        while (!minHeap.isEmpty()) {
            result[i] = minHeap.poll().getKey();
            i++;
        }

        return result;
    }

//    public int[] topKFrequent(int[] nums, int k) {
//        Map<Integer, Integer> counter = new HashMap<>();
//
//        for (int num : nums) {
//            counter.put(num, counter.getOrDefault(num, 0) + 1);
//        }
//
//        List[] array = new List[nums.length + 1];
//
//        for (Map.Entry<Integer, Integer> entry : counter.entrySet()) {
//            if (array[entry.getValue()] == null) {
//                array[entry.getValue()] = new ArrayList<>();
//            }
//            array[entry.getValue()].add(entry.getKey());
//        }
//
//        List<Integer> res = new ArrayList<>();
//
//        for (int i = nums.length; i > 0 && k > 0; i--) {
//            if (array[i] != null) {
//                List<Integer> curList = array[i];
//
//                int j = 0;
//                while (j < curList.size() && k > 0) {
//                    res.add(curList.get(j));
//                    j++;
//                    k--;
//                }
//            }
//        }
//
//        int[] result = new int[res.size()];
//
//        for (int i = 0; i < result.length; i++) {
//            result[i] = res.get(i);
//        }
//
//        return result;
//    }
}
