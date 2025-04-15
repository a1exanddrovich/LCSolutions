package com.bliznichenka.mathandgeometry.multiplystrings_43;

public class Solution {
    public String multiply(String num1, String num2) {
        // if either of the string is 0 then just return
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }

        int n = num1.length();

        String res = "0";
        for (int i = n - 1; i >= 0; i--) {
            StringBuilder multiplied = multiplication(num1.charAt(i), num2);
            // add the trailing zeros according to the digit position
            multiplied.append("0".repeat(n - i - 1));
            // add the previous number with the current one, just like in the task with LinkedList
            res = addition(res, multiplied.toString());
        }

        return res;
    }

    private static StringBuilder multiplication(char num1, String num2) {
        int n = Integer.parseInt(String.valueOf(num1));

        StringBuilder res = new StringBuilder();

        int i = num2.length() - 1;
        int carry = 0;
        while (i >= 0 || carry != 0) {
            int val = i >= 0 ? Integer.parseInt(String.valueOf(num2.charAt(i))) : 0;
            int multiplication = n * val + carry;
            res.append(multiplication % 10);
            carry = multiplication / 10;
            i--;
        }

        return res.reverse();
    }

    private static String addition(String num1, String num2) {
        StringBuilder res = new StringBuilder();
        int i = num1.length() - 1;
        int j = num2.length() - 1;

        int carry = 0;
        while (i >= 0 || j >= 0 || carry != 0) {
            int first = i >= 0 ? Integer.parseInt(String.valueOf(num1.charAt(i))) : 0;
            int second = j >= 0 ? Integer.parseInt(String.valueOf(num2.charAt(j))) : 0;

            int sum = first + second + carry;
            res.append(sum % 10);
            carry = sum / 10;

            i--;
            j--;
        }

        return res.reverse().toString();
    }
}
