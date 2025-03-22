package com.bliznichenka.backtracking.permutationsii_47;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        dfs(result, map, new ArrayList<>(), nums.length);
        return result;
    }

    private static void dfs(
            List<List<Integer>> result,
            Map<Integer, Integer> map,
            List<Integer> cur,
            int expectedSize
    ) {
        if (cur.size() == expectedSize) {
            result.add(List.copyOf(cur));
            return;
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int count = entry.getValue();
            if (count > 0) {
                cur.add(entry.getKey());
                entry.setValue(count - 1);
                dfs(result, map, cur, expectedSize);
                cur.remove(cur.size() - 1);
                entry.setValue(count);
            }
        }
    }
}
