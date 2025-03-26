package com.bliznichenka.graphs.courseschedule_207;

public class Main {

    public static void main(String[] args) {
        Solution s = new Solution();

        int numCourses = 2;
        int[][] prerequisites = {{0, 1}, {1, 0}};
        System.out.println(s.canFinish(numCourses, prerequisites));

    }

}
