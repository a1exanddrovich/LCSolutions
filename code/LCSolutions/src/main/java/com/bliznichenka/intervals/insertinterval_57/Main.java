package com.bliznichenka.intervals.insertinterval_57;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[][] intervals = {{2, 4}, {7, 9}, {12, 15}};
        int[] newInterval = {0, 10};

        System.out.println(Arrays.deepToString(solution.insert(intervals, newInterval)));
    }
}
