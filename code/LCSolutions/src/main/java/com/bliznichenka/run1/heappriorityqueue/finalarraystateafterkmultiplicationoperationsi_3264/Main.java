package com.bliznichenka.run1.heappriorityqueue.finalarraystateafterkmultiplicationoperationsi_3264;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();

        int[] nums = {2,1,3,5,6};
        int k = 5;
        int multiplier = 2;
        System.out.println(Arrays.toString(s.getFinalState(nums, k, multiplier)));
    }
}
