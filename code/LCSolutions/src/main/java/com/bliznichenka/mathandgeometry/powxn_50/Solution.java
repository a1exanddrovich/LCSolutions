package com.bliznichenka.mathandgeometry.powxn_50;

public class Solution {
    public double myPow(double x, int n) {
        double powered = helper(x, Math.abs(n));
        return n < 0 ? 1 / powered : powered;
    }

    private static double helper(double x, int n) {
        if (n == 0) {
            return 1.0;
        }
        if (x == 0) {
            return 0.0;
        }

        if (n % 2 == 0) {
            double res = helper(x, n / 2);
            return res * res;
        } else {
            double res = helper(x, n / 2);
            return x * res * res;
        }
    }
}
