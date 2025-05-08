package com.bliznichenka.stack.makethestringgreat_1504;

import java.util.Stack;

public class Solution {
    public String makeGood(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            int prevStackSize = stack.size();
            if (!stack.isEmpty() && (c + 32 == stack.peek() || c - 32 == stack.peek())) {
                stack.pop();
            }

            if (prevStackSize == stack.size()) {
                stack.push(c);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        sb.reverse();

        return sb.toString();
    }
}
