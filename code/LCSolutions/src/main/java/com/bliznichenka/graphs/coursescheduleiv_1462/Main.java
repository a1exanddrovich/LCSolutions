package com.bliznichenka.graphs.coursescheduleiv_1462;

public class Main {

    public static void main(String[] args) {
        Solution s = new Solution();

        int numCourses = 6;
        int[][] prerequisites = {{1, 0}, {2, 1}, {3, 1}, {1, 4}, {5, 4}};
        int[][] queries = {{1, 0}, {2, 1}};
        System.out.println(s.checkIfPrerequisite(numCourses, prerequisites, queries));
    }

}
