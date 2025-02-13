package com.bliznichenka.twopointers.foursum_18;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums = {-1, 0, 1, 2, -1, -4};
        int target = 2;
        System.out.println(solution.fourSum(nums, target));
    }
}
