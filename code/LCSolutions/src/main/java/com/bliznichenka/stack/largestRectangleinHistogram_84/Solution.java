package com.bliznichenka.stack.largestRectangleinHistogram_84;

import javafx.util.Pair;

import java.util.Stack;

public class Solution {
    public int largestRectangleArea(int[] heights) {
        // (height, index)
        Stack<Pair<Integer, Integer>> stack = new Stack<>();

        int max = 0;
        for (int i = 0; i < heights.length; i++) {
            int start = i;
            while (!stack.isEmpty() && stack.peek().getKey() > heights[i]) {
                Pair<Integer, Integer> popped = stack.pop();
                int height = popped.getKey();
                int index = popped.getValue();
                max = Math.max(max, height * (i - index));
                start = index;
            }

            stack.push(new Pair<>(heights[i], start));
        }

        while (!stack.isEmpty()) {
            Pair<Integer, Integer> popped = stack.pop();
            int height = popped.getKey();
            int index = popped.getValue();
            max = Math.max(max, height * (heights.length - index));
        }

        return max;
    }
}
