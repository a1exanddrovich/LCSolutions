package com.bliznichenka.dynamicprogramming2d.coinchangeii_518;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int amount = 5;
        int[] coins = {1, 2, 5};
        System.out.println(solution.change(amount, coins));
    }
}
