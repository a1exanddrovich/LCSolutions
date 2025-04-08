package com.bliznichenka.greedy.lemonadechange_860;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public boolean lemonadeChange(int[] bills) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(5, 0);
        map.put(10, 0);
        map.put(20, 0);

        for (int bill : bills) {
            map.put(bill, map.get(bill) + 1);
            int change = bill - 5;
            while (change - 20 >= 0 && map.get(20) > 0) {
                change -= 20;
                map.put(20, map.get(20) - 1);
            }
            while (change - 10 >= 0 && map.get(10) > 0) {
                change -= 10;
                map.put(10, map.get(10) - 1);
            }
            while (change - 5 >= 0 && map.get(5) > 0) {
                change -= 5;
                map.put(5, map.get(5) - 1);
            }
            if (change != 0) {
                return false;
            }
        }

        return true;
    }

    // more effective on Leetcode, less readable but the same idea
//    public boolean lemonadeChange(int[] bills) {
//        int fives = 0;
//        int tens = 0;
//
//        for (int bill : bills) {
//            if (bill == 5) {
//                fives++;
//            } else if (bill == 10) {
//                tens++;
//                if (fives == 0) {
//                    return false;
//                }
//                fives--;
//            } else {
//                if (tens >= 1 && fives >= 1) {
//                    tens--;
//                    fives--;
//                } else if (fives >= 3) {
//                    fives -= 3;
//                } else {
//                    return false;
//                }
//            }
//        }
//
//        return true;
//    }
}
