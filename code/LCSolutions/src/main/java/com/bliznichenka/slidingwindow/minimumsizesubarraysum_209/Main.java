package com.bliznichenka.slidingwindow.minimumsizesubarraysum_209;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums = {2, 3, 1, 2, 10, 4};
        int target = 7;
        System.out.println(solution.minSubArrayLen(target, nums));
    }
}
