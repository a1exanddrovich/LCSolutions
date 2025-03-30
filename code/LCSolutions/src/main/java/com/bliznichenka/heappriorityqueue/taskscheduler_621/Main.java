package com.bliznichenka.heappriorityqueue.taskscheduler_621;

public class Main {

    public static void main(String[] args) {
        Solution s = new Solution();

        char[] tasks = {'A', 'A', 'A', 'B', 'B', 'B'};
        int n = 2;
        System.out.println(s.leastInterval(tasks, n));
    }

}
