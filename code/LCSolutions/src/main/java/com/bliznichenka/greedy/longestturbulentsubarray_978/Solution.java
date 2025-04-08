package com.bliznichenka.greedy.longestturbulentsubarray_978;

public class Solution {
    public int maxTurbulenceSize(int[] arr) {
        int max = 1;

        int l = 0;
        int r = 1;
        String prevSign = "";
        while (r < arr.length) {
            if (arr[r - 1] > arr[r] && !prevSign.equals(">")) {
                max = Math.max(max, r - l + 1);
                prevSign = ">";
                r++;
            } else if (arr[r - 1] < arr[r] && !prevSign.equals("<")) {
                max = Math.max(max, r - l + 1);
                prevSign = "<";
                r++;
            } else {
                if (arr[r - 1] == arr[r]) {
                    r++;
                }

                l = r - 1;
                prevSign = "";
            }
        }

        return max;
    }
}
