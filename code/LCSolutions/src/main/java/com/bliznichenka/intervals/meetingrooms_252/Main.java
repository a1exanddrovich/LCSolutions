package com.bliznichenka.intervals.meetingrooms_252;


public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[][] intervals = {{0,30},{5,10},{15,20}};
        System.out.println(solution.canAttendMeetings(intervals));
    }
}
