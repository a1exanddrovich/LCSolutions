package com.bliznichenka.heappriorityqueue.kclosestpointstoorigin_973;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Solution s = new Solution();

        int[][] points = {{1, 3}, {-2, 2}};
        int k = 1;
        System.out.println(Arrays.deepToString(s.kClosest(points, k)));
    }

}
