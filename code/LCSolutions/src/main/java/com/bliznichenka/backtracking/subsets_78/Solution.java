package com.bliznichenka.backtracking.subsets_78;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(nums, 0, result, new ArrayList<>());
        return result;
    }

    private static void dfs(int[] nums,
                            int i,
                            List<List<Integer>> result,
                            List<Integer> cur) {
        if (i == nums.length) {
            result.add(new ArrayList<>(cur));
            return;
        }

        cur.add(nums[i]);
        dfs(nums, i + 1, result, cur);
        cur.remove(cur.size() - 1);
        dfs(nums, i + 1, result, cur);
    }
}
