package com.bliznichenka.arraysandhashing.groupanagrams_49;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<Map<Character, Integer>, List<String>> map = new HashMap<>();

        for (String word : strs) {
            Map<Character, Integer> counterMap = toCounterMap(word);
            if (!map.containsKey(counterMap)) {
                map.put(counterMap, new ArrayList<>());
            }

            map.get(counterMap).add(word);
        }

        return new ArrayList<>(map.values());
    }

    private static Map<Character, Integer> toCounterMap(String word) {
        Map<Character, Integer> counter = new HashMap<>();

        for (char c : word.toCharArray()) {
            counter.put(c, counter.getOrDefault(c, 0) + 1);
        }

        return counter;
    }
}
