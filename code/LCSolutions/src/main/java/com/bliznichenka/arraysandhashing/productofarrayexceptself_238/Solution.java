package com.bliznichenka.arraysandhashing.productofarrayexceptself_238;

public class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] answer = new int[nums.length];

        int prefix = 1;
        for (int i = 0; i < nums.length; i++) {
            answer[i] = prefix;
            prefix *= nums[i];
        }

        prefix = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            answer[i] *= prefix;
            prefix *= nums[i];
        }

        return answer;
    }
}
