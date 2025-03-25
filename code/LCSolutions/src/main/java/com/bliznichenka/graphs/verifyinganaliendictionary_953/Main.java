package com.bliznichenka.graphs.verifyinganaliendictionary_953;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();

        String[] words = {"hello","leetcode"};
        String order = "hlabcdefgijkmnopqrstuvwxyz";
        System.out.println(s.isAlienSorted(words, order));
    }
}
