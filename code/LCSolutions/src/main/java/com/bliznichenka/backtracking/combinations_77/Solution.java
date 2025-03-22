package com.bliznichenka.backtracking.combinations_77;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(result, new ArrayList<>(), 1, n, k);
        return result;
    }

    private static void dfs(
            List<List<Integer>> result,
            List<Integer> curComb,
            int num,
            int n,
            int k
    ) {
        if (curComb.size() == k) {
            result.add(List.copyOf(curComb));
            return;
        }
        if (num > n) {
            return;
        }

        curComb.add(num);
        dfs(result, curComb, num + 1, n, k);
        curComb.remove(curComb.size() - 1);
        dfs(result, curComb, num + 1, n, k);
    }
}
