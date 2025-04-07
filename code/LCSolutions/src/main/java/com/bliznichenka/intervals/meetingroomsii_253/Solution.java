package com.bliznichenka.intervals.meetingroomsii_253;

import java.util.Arrays;

public class Solution {
    public int minMeetingRooms(int[][] intervals) {
        int[] starts = new int[intervals.length];
        int[] ends = new int[intervals.length];
        for (int i = 0; i < intervals.length; i++) {
            starts[i] = intervals[i][0];
            ends[i] = intervals[i][1];
        }

        Arrays.sort(starts);
        Arrays.sort(ends);

        int maxMeetings = 0;
        int curMeetingsCount = 0;
        int i = 0;
        int j = 0;
        while (i < starts.length) {
            if (starts[i] < ends[j]) {
                curMeetingsCount++;
                i++;
            } else {
                curMeetingsCount--;
                j++;
            }
            maxMeetings = Math.max(maxMeetings, curMeetingsCount);
        }

        return maxMeetings;
    }
}
