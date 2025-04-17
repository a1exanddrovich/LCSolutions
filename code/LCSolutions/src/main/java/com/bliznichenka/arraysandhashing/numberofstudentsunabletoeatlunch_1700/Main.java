package com.bliznichenka.arraysandhashing.numberofstudentsunabletoeatlunch_1700;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] students = {1, 1, 0, 0};
        int[] sandwiches = {0, 1, 0, 1};
        System.out.println(solution.countStudents(students, sandwiches));
    }
}
