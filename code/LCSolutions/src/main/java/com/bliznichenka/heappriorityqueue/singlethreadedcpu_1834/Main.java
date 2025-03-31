package com.bliznichenka.heappriorityqueue.singlethreadedcpu_1834;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Solution s = new Solution();

        int[][] tasks = {{7, 1}, {6, 3}, {1, 3}};
        System.out.println(Arrays.toString(s.getOrder(tasks)));
    }

}
