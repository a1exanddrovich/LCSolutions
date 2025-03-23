package com.bliznichenka.backtracking.partitiontokequalsumsubsets_698;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums = {1, 1, 2, 2};
        int k = 2;
        System.out.println(solution.canPartitionKSubsets(nums, k));
    }
}
