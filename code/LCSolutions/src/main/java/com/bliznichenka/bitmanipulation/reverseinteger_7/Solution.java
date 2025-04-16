package com.bliznichenka.bitmanipulation.reverseinteger_7;

public class Solution {
    public int reverse(int x) {
        int res = 0;

        while (x != 0) {
            int lastDigit = x % 10;
            x /= 10;

            if (res > Integer.MAX_VALUE / 10
                    || (res == Integer.MAX_VALUE / 10 && lastDigit > 7)) {
                return 0;
            }
            if (res < Integer.MIN_VALUE / 10
                    || (res == Integer.MIN_VALUE / 10 && lastDigit > 8)) {
                return 0;
            }

            res = res * 10 + lastDigit;
        }

        return res;
    }
}
