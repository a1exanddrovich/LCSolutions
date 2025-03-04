package com.bliznichenka.binarysearch.findinmountainarray_1095;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        MountainArray mountainArray = new MountainArray(new int[]{1, 2, 3, 4, 5, 3, 1});
        int target = 3;
        System.out.println(solution.findInMountainArray(target, mountainArray));
    }

    public static final class MountainArray {
        private final int[] arr;

        private MountainArray(int[] arr) {
            this.arr = arr;
        }

        int get(int index) {
            return arr[index];
        }

        int length() {
            return arr.length;
        }
    }
}
