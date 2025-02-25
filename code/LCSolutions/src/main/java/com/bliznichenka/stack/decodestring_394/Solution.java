package com.bliznichenka.stack.decodestring_394;

import java.util.Stack;

public class Solution {
    public String decodeString(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ']') {
                StringBuilder curString = new StringBuilder();

                while (stack.peek() != '[') {
                    curString.append(stack.pop());
                }
                stack.pop();

                curString.reverse();

                StringBuilder number = new StringBuilder();
                while (!stack.isEmpty() && Character.isDigit(stack.peek())) {
                    number.append(stack.pop());
                }

                int k = Integer.parseInt(number.reverse().toString());

                for (int j = 0; j < k; j++) {
                    for (char c : curString.toString().toCharArray()) {
                        stack.push(c);
                    }
                }
            } else {
                stack.push(s.charAt(i));
            }
        }

        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }

        return result.reverse().toString();
    }
}
