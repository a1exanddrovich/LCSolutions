package com.bliznichenka.bitmanipulation.reversebits_190;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // put the 0b in the beginning to tell the int is in the binary format
        int n = 0b0000010100101000001111010011100;
        System.out.println(solution.reverseBits(n));
    }
}
