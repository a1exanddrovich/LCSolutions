package com.bliznichenka.graphs.coursescheduleii_210;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Solution s = new Solution();

        int numCourses = 6;
        int[][] prerequisites = {{5, 0}, {0, 1}, {0, 2}, {4, 0}, {1, 3}, {3, 2}, {2, 0}};
        System.out.println(Arrays.toString(s.findOrder(numCourses, prerequisites)));

    }

}
