package com.bliznichenka.intervals.mergeintervals_56;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        System.out.println(Arrays.deepToString(solution.merge(intervals)));
    }
}
