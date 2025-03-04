package com.bliznichenka.binarysearch.findinmountainarray_1095;

public class Solution {
    public int findInMountainArray(int target, Main.MountainArray mountainArr) {
        int len = mountainArr.length();
        int l = 0;
        int r = len - 1;
        int peakIndex = 0;

        while (l <= r) {
            int m = l + (r - l) / 2;
            int prev =m - 1 >= 0 ? mountainArr.get(m - 1) : Integer.MIN_VALUE;
            int cur = mountainArr.get(m);
            int next = m + 1 < len ? mountainArr.get(m + 1) : Integer.MIN_VALUE;

            if (prev < cur && cur > next) {
                peakIndex = m;
                break;
            } else if (prev > cur) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }

        l = 0;
        r = peakIndex;
        while (l <= r) {
            int m = l + (r - l) / 2;

            int cur =  mountainArr.get(m);
            if (cur == target) {
                return m;
            } else if (cur < target) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }

        l = peakIndex + 1;
        r = len - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;

            int cur =  mountainArr.get(m);
            if (cur == target) {
                return m;
            } else if (cur > target) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }

        return -1;
    }
}
