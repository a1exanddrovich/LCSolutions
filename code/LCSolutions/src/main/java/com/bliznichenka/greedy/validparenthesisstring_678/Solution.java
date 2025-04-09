package com.bliznichenka.greedy.validparenthesisstring_678;

public class Solution {
    public boolean checkValidString(String s) {
        int leftMin = 0;
        int leftMax = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                leftMin++;
                leftMax++;
            } else if (c == ')') {
                leftMin--;
                leftMax--;
            } else {
                leftMin--;
                leftMax++;
            }

            if (leftMax < 0) {
                return false;
            }
            if (leftMin < 0) {
                leftMin = 0;
            }
        }

        return leftMin == 0;
    }

    // The solution below is more understandable, so can be the main one.

//    public boolean checkValidString(String s) {
//        Stack<Integer> parStack = new Stack<>();
//        Stack<Integer> starStack = new Stack<>();
//
//        for (int i = 0; i < s.length(); i++) {
//            char c = s.charAt(i);
//            if (c == '(') {
//                parStack.push(i);
//            } else if (c == '*') {
//                starStack.push(i);
//            } else {
//                if (parStack.isEmpty() && starStack.isEmpty()) {
//                    return false;
//                }
//
//                if (!parStack.isEmpty()) {
//                    parStack.pop();
//                } else {
//                    starStack.pop();
//                }
//            }
//        }
//
//        while (!parStack.isEmpty()
//                && !starStack.isEmpty()
//                && starStack.peek() > parStack.peek()) {
//            parStack.pop();
//            starStack.pop();
//        }
//
//        return parStack.isEmpty();
//    }
}
