package com.bliznichenka.bitmanipulation.bitwiseandofnumbersrange_201;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int left = 2147483646;
        int right = 2147483647;
        System.out.println(solution.rangeBitwiseAnd(left, right));
    }
}
