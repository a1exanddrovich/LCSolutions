package com.bliznichenka.intervals.nonoverlappingintervals_435;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int result = 0;
        Arrays.sort(intervals, Comparator.comparingInt(interval -> interval[0]));

        int[] lastInterval = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];
            int lastEnd = lastInterval[1];

            if (lastEnd > start) {
                result++;
                if (lastEnd > end) {
                    lastInterval = intervals[i];
                }
            } else {
                lastInterval = intervals[i];
            }
        }

        return result;
    }
}
