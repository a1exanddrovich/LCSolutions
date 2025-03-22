package com.bliznichenka.backtracking.permutations_46;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        return dfs(0, nums);
    }

    private static List<List<Integer>> dfs(int index, int[] nums) {
        if (index == nums.length) {
            List<List<Integer>> result = new ArrayList<>();
            result.add(new ArrayList<>());
            return result;
        }

        List<List<Integer>> resPermutations = new ArrayList<>();

        List<List<Integer>> permutations = dfs(index + 1, nums);
        for (List<Integer> p : permutations) {
            for (int i = 0; i < p.size() + 1; i++) {
                List<Integer> pCopy = new ArrayList<>(p);
                pCopy.add(i, nums[index]);
                resPermutations.add(pCopy);
            }
        }

        return resPermutations;
    }
}
