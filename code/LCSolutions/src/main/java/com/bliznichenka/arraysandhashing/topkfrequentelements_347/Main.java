package com.bliznichenka.arraysandhashing.topkfrequentelements_347;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums = {1,1,1,2,2,3};
        int k = 2;
        System.out.println(Arrays.toString(solution.topKFrequent(nums, k)));
    }
}
