package com.bliznichenka.stack.evaluatereversepolishnotation_150;

import java.util.Stack;

public class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for (String token : tokens) {
            switch (token) {
                case "+" -> {
                    int second = stack.pop();
                    int first = stack.pop();
                    stack.push(first + second);
                }
                case "-" -> {
                    int second = stack.pop();
                    int first = stack.pop();
                    stack.push(first - second);
                }
                case "*" -> {
                    int second = stack.pop();
                    int first = stack.pop();
                    stack.push(first * second);
                }
                case "/" -> {
                    int second = stack.pop();
                    int first = stack.pop();
                    stack.push(first / second);
                }
                default -> stack.push(Integer.parseInt(token));
            }
        }

        return stack.pop();
    }
}
