package com.bliznichenka.greedy.dota2senate_649;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    public String predictPartyVictory(String senate) {
        Deque<Integer> radiants = new ArrayDeque<>();
        Deque<Integer> dires = new ArrayDeque<>();
        int offset = senate.length();

        for (int i = 0; i < senate.length(); i++) {
            if (senate.charAt(i) == 'R') {
                radiants.addFirst(i);
            } else {
                dires.addFirst(i);
            }
        }

        while (!radiants.isEmpty() && !dires.isEmpty()) {
            int radiant = radiants.pollLast();
            int dire = dires.pollLast();
            if (radiant < dire) {
                radiants.addFirst(radiant + offset);
            } else {
                dires.addFirst(dire + offset);
            }
        }

        return !radiants.isEmpty() ? "Radiant" : "Dire";
    }
}
