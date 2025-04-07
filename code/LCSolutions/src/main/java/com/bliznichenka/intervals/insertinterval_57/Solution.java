package com.bliznichenka.intervals.insertinterval_57;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < intervals.length; i++) {
            int newStart = newInterval[0];
            int newEnd = newInterval[1];
            int oldStart = intervals[i][0];
            int oldEnd = intervals[i][1];

            // if new interval goes before the old one
            if (newEnd < oldStart) {
                res.add(List.of(newStart, newEnd));
                while (i < intervals.length) {
                    res.add(List.of(intervals[i][0], intervals[i][1]));
                    i++;
                }
                // return the result right here
                return toArray(res);
                // if new interval goes after the old one
            } else if (oldEnd < newStart) {
                res.add(List.of(oldStart, oldEnd));
            } else {
                // merge the old one and the new one
                newInterval[0] = Math.min(oldStart, newStart);
                newInterval[1] = Math.max(oldEnd, newEnd);
            }
        }
        res.add(List.of(newInterval[0], newInterval[1]));

        return toArray(res);
    }

    private static int[][] toArray(List<List<Integer>> list) {
        int[][] array = new int[list.size()][];

        for (int j = 0; j < list.size(); j++) {
            array[j] = new int[]{list.get(j).get(0), list.get(j).get(1)};
        }

        return array;
    }
}
