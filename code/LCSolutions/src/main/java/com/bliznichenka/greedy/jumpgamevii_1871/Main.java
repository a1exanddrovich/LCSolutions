package com.bliznichenka.greedy.jumpgamevii_1871;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        String s = "011010";
        int minJump = 2;
        int maxJump = 3;
        System.out.println(solution.canReach(s, minJump, maxJump));
    }
}
