package com.bliznichenka.arraysandhashing.majorityelement_169;

public class Solution {
    public int majorityElement(int[] nums) {
        int count = 0;
        int element = -1;

        for (int num : nums) {
            if (count == 0) {
                element = num;
            }

            if (num == element) {
                count++;
            } else {
                count--;
            }
        }

        return element;
    }
}
