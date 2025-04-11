package com.bliznichenka.dynamicprogramming2d.minimumcostfortickets_983;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();

        int[] days = {1, 4, 6, 7, 8, 20};
        int[] costs = {7, 2, 15};
        System.out.println(s.mincostTickets(days, costs));
    }
}
