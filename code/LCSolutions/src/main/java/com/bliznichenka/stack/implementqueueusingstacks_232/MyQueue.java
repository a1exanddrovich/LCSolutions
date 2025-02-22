package com.bliznichenka.stack.implementqueueusingstacks_232;

import java.util.Stack;

public class MyQueue {
    private final Stack<Integer> stack = new Stack<>();

    public void push(int x) {
        Stack<Integer> temp = new Stack<>();
        while (!stack.isEmpty()) {
            temp.push(stack.pop());
        }
        stack.push(x);
        while (!temp.isEmpty()) {
            stack.push(temp.pop());
        }
    }

    public int pop() {
        return stack.pop();
    }

    public int peek() {
        return stack.peek();
    }

    public boolean empty() {
        return stack.isEmpty();
    }
}

//class MyQueue {
//    private final Stack<Integer> pushOnly = new Stack<>();
//    private final Stack<Integer> popOnly = new Stack<>();
//
//    public void push(int x) {
//        pushOnly.push(x);
//    }
//
//    public int pop() {
//        if (popOnly.isEmpty()) {
//            moveToPopOnly();
//        }
//        return popOnly.pop();
//    }
//
//    public int peek() {
//        if (popOnly.isEmpty()) {
//            moveToPopOnly();
//        }
//        return popOnly.peek();
//    }
//
//    public boolean empty() {
//        return pushOnly.isEmpty() && popOnly.isEmpty();
//    }
//
//    private void moveToPopOnly() {
//        while (!pushOnly.isEmpty()) {
//            popOnly.push(pushOnly.pop());
//        }
//    }
//}
