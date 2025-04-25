package com.bliznichenka.advancedgraphs.sortitemsbygroupsrespectingdependencies_1203;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();

        int n = 8;
        int m = 2;
        int[] group = {-1, -1, 1, 0, 0, 1, 0, -1};
        List<List<Integer>> beforeItems = List.of(
                List.of(),
                List.of(6),
                List.of(5),
                List.of(6),
                List.of(3, 6),
                List.of(),
                List.of(),
                List.of()
        );
        System.out.println(Arrays.toString(s.sortItems(n, m, group, beforeItems)));
    }
}