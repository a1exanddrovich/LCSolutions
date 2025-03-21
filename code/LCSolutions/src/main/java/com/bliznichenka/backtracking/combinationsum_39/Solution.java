package com.bliznichenka.backtracking.combinationsum_39;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(candidates, target, 0, new ArrayList<>(), 0, result);
        return result;
    }

    private static void dfs(
            int[] candidates,
            int target,
            int curSum,
            List<Integer> curComb,
            int i,
            List<List<Integer>> result) {
        if (i >= candidates.length || curSum > target) {
            return;
        }
        if (curSum == target) {
            result.add(List.copyOf(curComb));
            return;
        }

        curComb.add(candidates[i]);
        dfs(candidates, target, curSum + candidates[i], curComb, i, result);
        curComb.remove(curComb.size() - 1);
        dfs(candidates, target, curSum, curComb, i + 1, result);
    }
}
