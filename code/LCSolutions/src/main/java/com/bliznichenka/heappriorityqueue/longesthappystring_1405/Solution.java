package com.bliznichenka.heappriorityqueue.longesthappystring_1405;

import javafx.util.Pair;

import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {
    public String longestDiverseString(int a, int b, int c) {
        Queue<Pair<Character, Integer>> maxHeap = new PriorityQueue<>(
                (p1, p2) -> p2.getValue() - p1.getValue()
        );
        if (a > 0) {
            maxHeap.add(new Pair<>('a', a));
        }
        if (b > 0) {
            maxHeap.add(new Pair<>('b', b));
        }
        if (c > 0) {
            maxHeap.add(new Pair<>('c', c));
        }

        StringBuilder result = new StringBuilder();
        while (!maxHeap.isEmpty()) {
            Pair<Character, Integer> polled = maxHeap.poll();
            char polledChar = polled.getKey();
            int count = polled.getValue();

            if (result.length() >= 2 &&
                    result.charAt(result.length() - 1) == polledChar &&
                    result.charAt(result.length() - 2) == polledChar) {
                if (maxHeap.isEmpty()) {
                    break; // will return
                }
                Pair<Character, Integer> nextPolled = maxHeap.poll();
                char nextC = nextPolled.getKey();
                int nextCount = nextPolled.getValue();
                result.append(nextC);
                if (nextCount > 1) {
                    maxHeap.add(new Pair<>(nextC, nextCount - 1));
                }
                maxHeap.add(new Pair<>(polledChar, count));
            } else {
                result.append(polledChar);
                if (count > 1) {
                    maxHeap.add(new Pair<>(polledChar, count - 1));
                }
            }
        }

        return result.toString();
    }
}
