package com.bliznichenka.slidingwindow.numberofsubarraysofsizekandaveragegreaterthanorequaltothreshold_1343;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] arr = {2, 2, 2, 2, 5, 5, 5, 8};
        int k = 3;
        int threshold = 4;
        System.out.println(s.numOfSubarrays(arr, k, threshold));
    }
}
