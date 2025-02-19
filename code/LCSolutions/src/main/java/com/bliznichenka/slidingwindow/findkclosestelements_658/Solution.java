package com.bliznichenka.slidingwindow.findkclosestelements_658;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int l = 0;
        int r = arr.length - 1;

        while (r - l + 1 > k) {
            if (Math.abs(arr[l] - x) <= Math.abs(arr[r] - x)) {
                r--;
            } else {
                l++;
            }
        }

        List<Integer> result = new ArrayList<>();
        for (int i = l; i <= r; i++) {
            result.add(arr[i]);
        }
        return result;
    }

    public List<Integer> findClosestElements1(int[] arr, int k, int x) {
        int l = 0;
        int r = arr.length - k;

        while (l < r) {
            int m = (l + r) / 2;

            if (x - arr[m] > arr[m + k] - x) {
                l = m + 1;
            } else {
                r = m;
            }
        }

        List<Integer> result = new ArrayList<>();
        for (int i = l; i < l + k; i++) {
            result.add(arr[i]);
        }

        return result;
    }
}
