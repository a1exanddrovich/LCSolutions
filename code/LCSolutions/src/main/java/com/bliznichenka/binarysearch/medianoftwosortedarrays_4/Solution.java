package com.bliznichenka.binarysearch.medianoftwosortedarrays_4;

public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] a;
        int[] b;

        if (nums1.length < nums2.length) {
            a = nums1;
            b = nums2;
        } else {
            a = nums2;
            b = nums1;
        }

        int total = a.length + b.length;
        int half = total / 2;

        int l = 0;
        int r = a.length - 1;

        var result = 0.0;

        while (l <= r) {
            int i = (l + r) / 2;
            int j = half - i - 2;

            int aLeft = i >= 0 ? a[i] : Integer.MIN_VALUE;
            int aRight = i + 1 < a.length ? a[i + 1] : Integer.MAX_VALUE;

            int bLeft = j >= 0 ? b[j] : Integer.MIN_VALUE;
            int bRight = j + 1 < b.length ? b[j + 1] : Integer.MAX_VALUE;

            if (aLeft <= bRight && bLeft <= aRight) {
                if (total % 2 != 0) {
                    result = Math.min(aRight, bRight);
                } else {
                    result = (double) (Math.max(aLeft, bLeft) + Math.min(aRight, bRight)) / 2;
                }

                break;
            } else if (aLeft > bRight) {
                r = i - 1;
            } else {
                l = i + 1;
            }
        }

        return result;
    }
}
