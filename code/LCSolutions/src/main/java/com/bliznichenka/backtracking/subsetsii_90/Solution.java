package com.bliznichenka.backtracking.subsetsii_90;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        dfs(result, new ArrayList<>(), nums, 0);
        return result;
    }

    private static void dfs(
            List<List<Integer>> result,
            List<Integer> cur,
            int[] nums,
            int i
    ) {
        if (i >= nums.length) {
            result.add(List.copyOf(cur));
            return;
        }

        cur.add(nums[i]);
        dfs(result, cur, nums, i + 1);
        cur.remove(cur.size() - 1);

        int j = i + 1;
        while (j < nums.length && nums[i] == nums[j]) {
            j++;
        }
        dfs(result, cur, nums, j);
    }
}
