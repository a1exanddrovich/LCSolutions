package com.bliznichenka.heappriorityqueue.reorganizestring_767;

import javafx.util.Pair;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {
    public String reorganizeString(String s) {
        Map<Character, Integer> counter = new HashMap<>();
        for (char c : s.toCharArray()) {
            counter.put(c, counter.getOrDefault(c, 0) + 1);
        }

        Queue<Pair<Character, Integer>> maxHeap = new PriorityQueue<>(
                (p1, p2) -> p2.getValue() - p1.getValue()
        );
        for (Map.Entry<Character, Integer> entry : counter.entrySet()) {
            maxHeap.add(new Pair<>(entry.getKey(), entry.getValue()));
        }

        StringBuilder result = new StringBuilder();
        while (!maxHeap.isEmpty()) {
            // the input string never contains % so, we can use it for the first iteration
            char prevChar = result.isEmpty() ? '%' : result.charAt(result.length() - 1);
            Pair<Character, Integer> polled = maxHeap.poll();
            char curChar = polled.getKey();
            int count = polled.getValue();

            if (curChar == prevChar) {
                if (maxHeap.isEmpty()) {
                    return "";
                } else {
                    Pair<Character, Integer> nextPolled = maxHeap.poll();
                    char nextChar = nextPolled.getKey();
                    int nextCount = nextPolled.getValue();
                    result.append(nextChar);
                    if (nextCount > 1) {
                        maxHeap.add(new Pair<>(nextChar, nextCount - 1));
                    }
                    maxHeap.add(new Pair<>(curChar, count));
                }
            } else {
                result.append(curChar);
                if (count > 1) {
                    maxHeap.add(new Pair<>(curChar, count - 1));
                }
            }
        }

        return result.toString();
    }
}
