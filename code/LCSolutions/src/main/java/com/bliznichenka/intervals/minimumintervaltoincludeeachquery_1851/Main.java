package com.bliznichenka.intervals.minimumintervaltoincludeeachquery_1851;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[][] intervals = {{1, 4}, {2, 4}, {3, 6}, {4, 4}};
        int[] queries = {2, 3, 4, 5};
        System.out.println(Arrays.toString(solution.minInterval(intervals, queries)));
    }
}
