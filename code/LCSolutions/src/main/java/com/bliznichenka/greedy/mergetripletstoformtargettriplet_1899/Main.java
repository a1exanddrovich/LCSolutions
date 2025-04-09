package com.bliznichenka.greedy.mergetripletstoformtargettriplet_1899;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[][] triplets = {{2, 5, 3}, {2, 3, 4}, {1, 2, 5}, {5, 2, 3}};
        int[] target = {5, 5, 5};
        System.out.println(solution.mergeTriplets(triplets, target));
    }
}
