package com.bliznichenka.intervals.meetingroomsiii_2402;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {
    public int mostBooked(int n, int[][] meetings) {
        Arrays.sort(meetings, Comparator.comparingInt(meeting -> meeting[0]));

        // roomIndex
        Queue<Integer> freeRoomsMinHeap = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            freeRoomsMinHeap.add(i);
        }
        // [roomIndex, roomFreeTime]
        // this comparator is important because when we poll a single time, we want to poll
        // the smallest index if the end times are equal
        Queue<List<Integer>> usedRoomsMinHeap = new PriorityQueue<>(
            (l1, l2) -> {
                if (l1.get(1).equals(l2.get(1))) {
                    return l1.get(0) - l2.get(0);
                }
                return l1.get(1) - l2.get(1);
            }
        );
        int[] count = new int[n];

        for (int[] meeting : meetings) {
            // first we want to finish all the meetings before the start time
            while (!usedRoomsMinHeap.isEmpty() && usedRoomsMinHeap.peek().get(1) <= meeting[0]) {
                List<Integer> polled = usedRoomsMinHeap.poll();
                int index = polled.get(0);
                freeRoomsMinHeap.add(index);
            }

            int endTime = meeting[1];
            // if still no rooms available, then poll once
            if (freeRoomsMinHeap.isEmpty()) {
                List<Integer> polled = usedRoomsMinHeap.poll();
                int index = polled.get(0);
                int prevMeetingEndTime = polled.get(1);
                freeRoomsMinHeap.add(index);
                endTime = prevMeetingEndTime + (meeting[1] - meeting[0]);
            }

            int roomIndex = freeRoomsMinHeap.poll();
            count[roomIndex]++;
            usedRoomsMinHeap.add(List.of(roomIndex, endTime));
        }

        int maxIndex = 0;
        int maxCount = 0;
        for (int i = 0; i < count.length; i++) {
            if (count[i] > maxCount) {
                maxIndex = i;
                maxCount = count[i];
            }
        }

        return maxIndex;
    }
}
