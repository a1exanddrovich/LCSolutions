package com.bliznichenka.dynamicprogramming1d.coinchange_322;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();

        int[] coins = {1, 2, 5};
        int amount = 11;
        System.out.println(s.coinChange(coins, amount));
    }
}
