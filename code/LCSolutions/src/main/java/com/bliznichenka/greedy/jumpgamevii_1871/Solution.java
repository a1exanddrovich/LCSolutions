package com.bliznichenka.greedy.jumpgamevii_1871;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    public boolean canReach(String s, int minJump, int maxJump) {
        Deque<Integer> deque = new ArrayDeque<>();
        int farthest = 0;
        deque.addFirst(0);

        while (!deque.isEmpty()) {
            int index = deque.pollLast();
            int start = Math.max(farthest + 1, index + minJump);
            int end = Math.min(s.length() - 1, index + maxJump);

            for (int i = start; i <= end; i++) {
                if (s.charAt(i) == '0') {
                    if (i == s.length() - 1) {
                        return true;
                    }
                    deque.addFirst(i);
                }
            }
            farthest = index + maxJump;
        }
        return false;
    }
}
