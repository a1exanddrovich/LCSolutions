package com.bliznichenka.arraysandhashing.pascalstriangle_118;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(List.of(1));

        for (int i = 1; i < numRows; i++) {
            List<Integer> prevLevel = result.get(i - 1);
            List<Integer> curLevel = new ArrayList<>();

            curLevel.add(prevLevel.get(0));
            for (int j = 1; j < prevLevel.size(); j++) {
                curLevel.add(prevLevel.get(j) + prevLevel.get(j - 1));
            }
            curLevel.add(prevLevel.get(prevLevel.size() - 1));

            result.add(curLevel);
        }

        return result;
    }
}
