package com.bliznichenka.stack.carfleet_853;

import javafx.util.Pair;

import java.util.*;

public class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        // [position, speed]
        List<Pair<Integer, Integer>> list = new ArrayList<>();
        for (int i = 0; i < position.length; i++) {
            list.add(new Pair<>(position[i], speed[i]));
        }
        list.sort(Comparator.comparing(Pair::getKey));

        Stack<Double> stack = new Stack<>();

        for (int i = list.size() - 1; i >= 0; i--) {
            double requiredTime = (double) (target - list.get(i).getKey()) / list.get(i).getValue();

            if (stack.isEmpty() || requiredTime > stack.peek()) {
                stack.push(requiredTime);
            }
        }

        return stack.size();
    }
}
