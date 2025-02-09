package com.bliznichenka.arraysandhashing.subarraysumequalsk_560;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int subarraySum(int[] nums, int k) {
        int result = 0;
        int curPrefixSum = 0;
        Map<Integer, Integer> prefixSumsCount = new HashMap<>();

        prefixSumsCount.put(0, 1);

        for (int n : nums) {
            curPrefixSum += n;
            int toBeChoppedOff = curPrefixSum - k;
            if (prefixSumsCount.containsKey(toBeChoppedOff)) {
                result += prefixSumsCount.get(toBeChoppedOff);
            }
            prefixSumsCount.put(curPrefixSum, prefixSumsCount.getOrDefault(curPrefixSum, 0) + 1);
        }

        return result;
    }
}
