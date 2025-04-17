package com.bliznichenka.arraysandhashing.numberofstudentsunabletoeatlunch_1700;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);
        map.put(1, 0);
        for (int student : students) {
            map.put(student, map.get(student) + 1);
        }

        for (int sandwich : sandwiches) {
            if (map.get(sandwich).equals(0)) {
                break;
            }
            map.put(sandwich, map.get(sandwich) - 1);
        }

        return map.get(0) + map.get(1);
    }
}
