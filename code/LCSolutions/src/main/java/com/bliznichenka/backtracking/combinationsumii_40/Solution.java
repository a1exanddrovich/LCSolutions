package com.bliznichenka.backtracking.combinationsumii_40;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();

        dfs(result, candidates, target, 0, new ArrayList<>());

        return result;
    }

    private static void dfs(
            List<List<Integer>> result,
            int[] candidates,
            int leftTarget,
            int i,
            List<Integer> curComb
    ) {
        if (leftTarget == 0) {
            result.add(List.copyOf(curComb));
            return;
        }
        if (i >= candidates.length || leftTarget < 0) {
            return;
        }

        curComb.add(candidates[i]);
        dfs(result, candidates, leftTarget - candidates[i], i + 1, curComb);
        curComb.remove(curComb.size() - 1);

        int j = i + 1;
        while (j < candidates.length && candidates[j] == candidates[i]) {
            j++;
        }
        dfs(result, candidates, leftTarget, j, curComb);
    }
}
