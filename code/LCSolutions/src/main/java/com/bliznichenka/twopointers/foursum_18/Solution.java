package com.bliznichenka.twopointers.foursum_18;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> quad = new ArrayList<>();

        kSum(4, 0, target, nums, result, quad);

        return result;
    }

    private void kSum(int k,
                      int startIndex,
                      // when we have a negative number, we'd increase the target
                      // and this may cause overflowing of int, so long is used.
                      long target,
                      int[] nums,
                      List<List<Integer>> result,
                      List<Integer> quad) {
        if (k != 2) {
            for (int i = startIndex; i < nums.length - k + 1; i++) {
                if (i > startIndex && nums[i - 1] == nums[i]) {
                    continue;
                }

                quad.add(nums[i]);
                kSum(k - 1,
                        i + 1,
                        target - nums[i], nums, result, quad);
                quad.remove(quad.size() - 1);
            }
        } else {
            int l = startIndex;
            int r = nums.length - 1;

            while (l < r) {
                int sum = nums[l] + nums[r];

                if (sum < target) {
                    l++;
                } else if (sum > target) {
                    r--;
                } else {
                    List<Integer> foundComb = new ArrayList<>();
                    foundComb.addAll(quad);
                    foundComb.add(nums[l]);
                    foundComb.add(nums[r]);
                    result.add(foundComb);
                    do {
                        l++;
                    } while (nums[l - 1] == nums[l] && l < r);
                }
            }
        }
    }
}
