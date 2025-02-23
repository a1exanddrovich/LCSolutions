package com.bliznichenka.stack.asteroidcollision_735;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] asteroids = {5, 10, -5};
        System.out.println(Arrays.toString(solution.asteroidCollision(asteroids)));
    }
}
