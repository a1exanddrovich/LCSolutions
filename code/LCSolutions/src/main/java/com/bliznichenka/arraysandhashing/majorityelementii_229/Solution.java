package com.bliznichenka.arraysandhashing.majorityelementii_229;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public List<Integer> majorityElement(int[] nums) {
        Map<Integer, Integer> counter = new HashMap<>();

        for (int n : nums) {
            if (!counter.containsKey(n)) {
                counter.put(n, 0);
            }

            counter.put(n, counter.get(n) + 1);

            if (counter.size() <= 2) {
                continue;
            }

            Map<Integer, Integer> newCounter = new HashMap<>();
            for (var entry : counter.entrySet()) {
                if (entry.getValue() > 1) {
                    newCounter.put(entry.getKey(), entry.getValue() - 1);
                }
            }
            counter = newCounter;
        }

        List<Integer> result = new ArrayList<>();

        for (int key : counter.keySet()) {
            int count = 0;
            for (int n : nums) {
                if (n == key) {
                    count++;
                }
            }

            if (count > (nums.length / 3)) {
                result.add(key);
            }
        }

        return result;
    }
}
