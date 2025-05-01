package com.bliznichenka.arraysandhashing.numberofseniorcitizens_2678;

public class Solution {
    public int countSeniors(String[] details) {
        int res = 0;
        for (String detail : details) {
            if (detail.charAt(11) > '6' ||
                    (detail.charAt(11) == '6' && detail.charAt(12) > '0')) {
                res++;
            }
        }

        return res;
    }
}
