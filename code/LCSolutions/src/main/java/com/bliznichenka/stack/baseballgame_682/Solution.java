package com.bliznichenka.stack.baseballgame_682;

import java.util.Stack;

public class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> stack = new Stack<>();

        for (String operation : operations) {
            switch (operation) {
                case "+" -> {
                    int first = stack.pop();
                    int second = stack.peek();
                    stack.push(first);
                    stack.push(first + second);
                }
                case "D" -> {
                    int peeked = stack.peek();
                    stack.push(2 * peeked);
                }
                case "C" -> stack.pop();
                default -> stack.push(Integer.parseInt(operation));
            }
        }

        int result = 0;

        while (!stack.isEmpty()) {
            result += stack.pop();
        }

        return result;
    }
}
