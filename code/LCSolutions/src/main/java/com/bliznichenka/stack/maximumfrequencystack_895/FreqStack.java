package com.bliznichenka.stack.maximumfrequencystack_895;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class FreqStack {
    private final Map<Integer, Integer> counter = new HashMap<>();
    private final Map<Integer, Stack<Integer>> stacks = new HashMap<>();
    private int max;

    public void push(int val) {
        counter.put(val, counter.getOrDefault(val, 0) + 1);
        int freq = counter.get(val);
        if (freq > max) {
            max = freq;
            stacks.put(max, new Stack<>());
        }

        stacks.get(freq).push(val);
    }

    public int pop() {
        int popped = stacks.get(max).pop();
        counter.put(popped, counter.get(popped) - 1);

        if (stacks.get(max).isEmpty()) {
            max--;
        }

        return popped;
    }

//    private final Map<Integer, Integer> counter = new HashMap<>();
//    private final List<Stack<Integer>> stacks = new ArrayList<>();
//
//    public void push(int val) {
//        counter.put(val, counter.getOrDefault(val, 0) + 1);
//        int freq = counter.get(val);
//        if (freq > stacks.size()) {
//            stacks.add(new Stack<>());
//        }
//
//        stacks.get(freq - 1).push(val);
//    }
//
//    public int pop() {
//        int popped = stacks.get(stacks.size() - 1).pop();
//        counter.put(popped, counter.get(popped) - 1);
//
//        if (stacks.get(stacks.size() - 1).isEmpty()) {
//            stacks.remove(stacks.size() - 1);
//        }
//
//        return popped;
//    }
}
