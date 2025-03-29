package com.bliznichenka.heappriorityqueue.kthlargestelementinastream_703;

public class Main {

    public static void main(String[] args) {
        int k = 3;
        int[] nums = {4, 5, 8, 2};
        KthLargest queue = new KthLargest(k, nums);

        System.out.println(queue.add(3));
        System.out.println(queue.add(5));
        System.out.println(queue.add(10));
        System.out.println(queue.add(9));
        System.out.println(queue.add(4));
    }

}
