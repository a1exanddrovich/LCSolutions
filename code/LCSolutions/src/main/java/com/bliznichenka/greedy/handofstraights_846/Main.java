package com.bliznichenka.greedy.handofstraights_846;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] hand = {1, 1, 3, 6, 2, 3, 4, 7, 9};
        int groupSize = 3;
        System.out.println(solution.isNStraightHand(hand, groupSize));
    }
}
