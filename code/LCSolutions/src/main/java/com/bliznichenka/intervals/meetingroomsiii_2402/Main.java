package com.bliznichenka.intervals.meetingroomsiii_2402;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int n = 2;
        int[][] meetings = {{0, 40}, {5, 10}, {15, 20}};
        System.out.println(solution.mostBooked(n, meetings));
    }
}
