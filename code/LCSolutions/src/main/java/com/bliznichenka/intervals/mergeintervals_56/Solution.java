package com.bliznichenka.intervals.mergeintervals_56;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(interval -> interval[0]));
        List<int[]> res = new ArrayList<>();
        res.add(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];
            int lastEnd = res.get(res.size() - 1)[1];

            if (lastEnd >= start) {
                res.get(res.size() - 1)[1] = Math.max(end, lastEnd);
            } else {
                res.add(new int[] {start, end});
            }
        }

        return res.toArray(new int[0][]);
    }
}
