package com.bliznichenka.heappriorityqueue.kthlargestelementinanarray_215;

import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {
    public int findKthLargest(int[] nums, int k) {
        Queue<Integer> minHeap = new PriorityQueue<>();

        for (int n : nums) {
            minHeap.add(n);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        return minHeap.peek();
    }

//    public int findKthLargest(int[] nums, int k) {
//        return quickSelect(0, nums.length - 1, nums, nums.length - k);
//    }
//
//    private static int quickSelect(int l, int r, int[] nums, int target) {
//        int p = l;
//
//        for (int i = l; i < r; i++) {
//            if (nums[i] <= nums[r]) {
//                int temp = nums[p];
//                nums[p] = nums[i];
//                nums[i] = temp;
//                p++;
//            }
//        }
//
//        int temp = nums[p];
//        nums[p] = nums[r];
//        nums[r] = temp;
//
//        if (target > p) {
//            return quickSelect(p + 1, r, nums, target);
//        } else if (target < p) {
//            return quickSelect(l, p - 1, nums, target);
//        } else {
//            return nums[p];
//        }
//    }
}
