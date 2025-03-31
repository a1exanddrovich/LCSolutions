package com.bliznichenka.heappriorityqueue.carpooling_1094;

public class Main {

    public static void main(String[] args) {
        Solution s = new Solution();

        int[][] trips = {{2, 1, 5}, {3, 3, 7}};
        int capacity = 5;
        System.out.println(s.carPooling(trips, capacity));
    }

}
