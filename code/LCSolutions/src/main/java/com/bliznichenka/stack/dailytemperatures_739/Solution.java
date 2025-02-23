package com.bliznichenka.stack.dailytemperatures_739;

import javafx.util.Pair;

import java.util.Stack;

public class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        // [temperatures[i], i]
        Stack<Pair<Integer, Integer>> stack = new Stack<>();
        int[] answer = new int[temperatures.length];

        for (int i = temperatures.length - 1; i >= 0; i--) {
            // <= is because if we have two elements with the same temperature
            // then it's better to push it since it has the smaller index and is
            // closer to the left elements.
            while (!stack.isEmpty() && stack.peek().getKey() <= temperatures[i]) {
                stack.pop();
            }

            if (!stack.isEmpty()) {
                answer[i] = stack.peek().getValue() - i;
            }

            stack.push(new Pair<>(temperatures[i], i));
        }

        return answer;
    }
}
