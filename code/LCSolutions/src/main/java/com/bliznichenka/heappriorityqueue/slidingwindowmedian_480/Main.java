package com.bliznichenka.heappriorityqueue.slidingwindowmedian_480;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Solution s = new Solution();

        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        System.out.println(Arrays.toString(s.medianSlidingWindow(nums, k)));
    }

}
