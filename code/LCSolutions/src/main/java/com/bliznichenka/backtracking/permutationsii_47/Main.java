package com.bliznichenka.backtracking.permutationsii_47;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {1, 1, 2};
        Set<Map.Entry<Object, Object>> entries = new HashMap<>().entrySet();

        System.out.println(s.permuteUnique(nums));
    }
}
