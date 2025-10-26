package com.bliznichenka.run2.arraysandhashing.containsduplicate_217;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for (int n : nums) {
            if (set.contains(n)) {
                return true;
            }
            set.add(n);
        }

        return false;
    }
}
