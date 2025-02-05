package com.bliznichenka.arraysandhashing.sortanarray_912;

import java.util.Arrays;

public class Solution {
    public int[] sortArray(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
        return nums;
    }

    private void mergeSort(int[] nums, int l, int r) {
        if (l == r) {
            return;
        }

        int m = l + (r - l) / 2;

        mergeSort(nums, l, m);
        mergeSort(nums, m + 1, r);

        merge(nums, l, m, r);
    }

    private void merge(int[] nums, int l, int m, int r) {
        int[] left = Arrays.copyOfRange(nums, l, m + 1);
        int[] right = Arrays.copyOfRange(nums, m + 1, r + 1);
        int i = 0;
        int j = 0;
        int k = l;

        while (i < left.length && j < right.length) {
            if (left[i] < right[j]) {
                nums[k] = left[i];
                i++;
            } else {
                nums[k] = right[j];
                j++;
            }
            k++;
        }

        while (i < left.length) {
            nums[k] = left[i];
            i++;
            k++;
        }

        while (j < right.length) {
            nums[k] = right[j];
            j++;
            k++;
        }
    }
}
