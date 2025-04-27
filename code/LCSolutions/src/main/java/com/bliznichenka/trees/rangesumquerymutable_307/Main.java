package com.bliznichenka.trees.rangesumquerymutable_307;

public class Main {
    public static void main(String[] args) {
        NumArray numArray = new NumArray(new int[]{1, 3, 5});
        System.out.println(numArray.sumRange(0, 2)); // return 1 + 3 + 5 = 9
        numArray.update(1, 2);   // nums = [1, 2, 5]
        System.out.println(numArray.sumRange(0, 2)); // return 1 + 2 + 5 = 8
    }
}
