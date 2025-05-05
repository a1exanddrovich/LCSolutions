package com.bliznichenka.slidingwindow.grumpybookstoreowner_1052;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] customers = {1, 0, 1, 2, 1, 1, 7, 5};
        int[] grumpy = {0, 1, 0, 1, 0, 1, 0, 1};
        int mins = 3;
        System.out.println(solution.maxSatisfied(customers, grumpy, mins));
    }
}
