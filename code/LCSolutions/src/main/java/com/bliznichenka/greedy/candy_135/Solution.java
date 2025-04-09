package com.bliznichenka.greedy.candy_135;

import java.util.Arrays;

public class Solution {
    public int candy(int[] ratings) {
        int[] arr = new int[ratings.length];
        Arrays.fill(arr, 1);

        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i - 1] < ratings[i]) {
                arr[i] = arr[i - 1] + 1;
            }
        }

        for (int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                arr[i] = Math.max(arr[i], arr[i + 1] + 1);
            }
        }

        int sum = 0;
        for (int n : arr) {
            sum += n;
        }
        return sum;
    }
}
