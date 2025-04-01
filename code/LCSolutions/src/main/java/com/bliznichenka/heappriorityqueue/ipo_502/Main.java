package com.bliznichenka.heappriorityqueue.ipo_502;

public class Main {

    public static void main(String[] args) {
        Solution s = new Solution();

        int k = 3;
        int w = 0;
        int[] profits = {1,2,3};
        int[] capital = {0,1,2};
        System.out.println(s.findMaximizedCapital(k, w, profits, capital));
    }

}
