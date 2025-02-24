package com.bliznichenka.stack.onlinestockspan_901;

import javafx.util.Pair;
import java.util.Stack;

public class StockSpanner {
    // [price, span]
    private final Stack<Pair<Integer, Integer>> stack = new Stack<>();

    public int next(int price) {
        int span = 1;

        while (!stack.isEmpty() && stack.peek().getKey() <= price) {
            int prevSpan = stack.pop().getValue();
            span += prevSpan;
        }

        stack.push(new Pair<>(price, span));

        return span;
    }
}
