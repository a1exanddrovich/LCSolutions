package com.bliznichenka.twopointers.threesum_15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<>();

        int k = 0;
        while (k < nums.length) {
            if (k > 0 && nums[k - 1] == nums[k]) {
                k++;
                continue;
            }
            int i = k + 1;
            int j = nums.length - 1;
            while (i < j) {
                int curSum = nums[k] + nums[i] + nums[j];
                if (curSum < 0) {
                    i++;
                } else if (curSum > 0) {
                    j--;
                } else {
                    result.add(List.of(nums[k], nums[i], nums[j]));
                    do {
                        i++;
                    } while (i < j && nums[i - 1] == nums[i]);
                }
            }
            k++;
        }

        return result;
    }
}
