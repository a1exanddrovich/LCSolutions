package com.bliznichenka.mathandgeometry.happynumber_202;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public boolean isHappy(int n) {
        Set<Integer> visited = new HashSet<>();

        while (!visited.contains(n)) {
            visited.add(n);

            int sum = 0;
            while (n != 0) {
                sum += (int) Math.pow((n % 10), 2);
                n /= 10;
            }
            n = sum;

            if (n == 1) {
                return true;
            }
        }

        return false;
    }
}
