package com.bliznichenka.stack.evaluatereversepolishnotation_150;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        String[] tokens = {"2", "1", "+", "3", "*"};
        System.out.println(solution.evalRPN(tokens));
    }
}
