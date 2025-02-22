package com.bliznichenka.stack.minstack_155;

import javafx.util.Pair;

import java.util.Stack;

public class MinStack {
    private final Stack<Pair<Integer, Integer>> stack = new Stack<>();

    public void push(int val) {
        if (stack.isEmpty()) {
            stack.push(new Pair<>(val, val));
        } else {
            int newMin = Math.min(val, stack.peek().getValue());
            stack.push(new Pair<>(val, newMin));
        }
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        return stack.peek().getKey();
    }

    public int getMin() {
        return stack.peek().getValue();
    }
}
