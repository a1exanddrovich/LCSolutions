package com.bliznichenka.greedy.partitionlabels_763;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public List<Integer> partitionLabels(String s) {
        Map<Character, Integer> lastOccurrence = new HashMap<>();
        for (int j = s.length() - 1; j >= 0; j--) {
            if (!lastOccurrence.containsKey(s.charAt(j))) {
                lastOccurrence.put(s.charAt(j), j);
            }
        }

        List<Integer> result = new ArrayList<>();
        int i = 0;
        int startIndex = 0;
        int splitIndex = 0;
        while (i < s.length()) {
            splitIndex = Math.max(splitIndex, lastOccurrence.get(s.charAt(i)));
            if (i == splitIndex) {
                result.add(splitIndex - startIndex + 1);
                startIndex = splitIndex + 1;
            }
            i++;
        }

        return result;
    }
}
