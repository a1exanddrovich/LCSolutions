package com.bliznichenka.stack.asteroidcollision_735;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();

        for (int asteroid : asteroids) {
            if (asteroid > 0) {
                stack.push(asteroid);
            } else {
                boolean toBeAdded = true;
                while (!stack.isEmpty() && stack.peek() > 0) {
                    if (stack.peek() < Math.abs(asteroid)) {
                        stack.pop();
                    } else {
                        if (stack.peek() == Math.abs(asteroid)) {
                            stack.pop();
                        }
                        toBeAdded = false;
                        break;
                    }
                }

                if (toBeAdded) {
                    stack.push(asteroid);
                }
            }
        }

        List<Integer> tempList = new ArrayList<>(stack);
        int[] result = new int[tempList.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = tempList.get(i);
        }
        return result;
    }
}
