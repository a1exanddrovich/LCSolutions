package com.bliznichenka.stack.validatestacksequences_946;

import java.util.Stack;

public class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();

        int j = 0;
        for (int element : pushed) {
            stack.push(element);

            while (!stack.isEmpty() && j < popped.length && stack.peek().equals(popped[j])) {
                stack.pop();
                j++;
            }
        }

        return stack.isEmpty();
    }
}
