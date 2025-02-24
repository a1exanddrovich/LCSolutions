package com.bliznichenka.stack.carfleet_853;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int target = 10;
        int[] position = {0, 4, 2};
        int[] speed = {2, 1, 3};
        System.out.println(solution.carFleet(target, position, speed));
    }
}
