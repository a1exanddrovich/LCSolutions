package com.bliznichenka.arraysandhashing.longestconsecutivesequence_128;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class Solution {
    public int longestConsecutive(int[] nums) {
        // we just check if each number is the start of a seq.
        // if it is then we count the seq length. We at most
        // visit the same number twice. Because we only go through
        // a number if it's a part a seq (1) and then when checking
        // if it starts a seq (2).
        Set<Integer> set = Arrays.stream(nums).boxed().collect(Collectors.toSet());
        int max = 0;

        // pay attention to this - we iterate through the set, not input array
        // that works out in case we have many duplicates of the "left boundary"
        // element in the array.
        for (int n : set) {
            if (!set.contains(n - 1)) {
                int len = 0;

                while (set.contains(n + len)) {
                    len++;
                }

                max = Math.max(max, len);
            }
        }

        return max;
    }
}
