package com.bliznichenka.twopointers.removeduplicatesfromsortedarrayii_80;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] arr = {-1, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int i = s.removeDuplicates(arr);
        System.out.println(i + " and " + Arrays.toString(arr));
    }

}
