package com.bliznichenka.backtracking.palindromepartitioning_131;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        dfs(result, new ArrayList<>(), s, 0);
        return result;
    }

    private static void dfs(
            List<List<String>> result,
            List<String> cur,
            String s,
            int startIndex
    ) {
        if (startIndex >= s.length()) {
            result.add(List.copyOf(cur));
            return;
        }

        for (int i = startIndex; i < s.length(); i++) {
            String partitioned = s.substring(startIndex, i + 1);
            if (isPalindrome(partitioned)) {
                cur.add(partitioned);
                dfs(result, cur, s, i + 1);
                cur.remove(cur.size() - 1);
            }
        }
    }

    private static boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

//    private final Map<Integer, List<List<String>>> cache = new HashMap<>();
//
//    public List<List<String>> partition(String s) {
//        cache.put(s.length(), List.of(new ArrayList<>()));
//        return dfs(s, 0);
//    }
//
//    private List<List<String>> dfs(String s, int startIndex) {
//        if (cache.containsKey(startIndex)) {
//            return cache.get(startIndex);
//        }
//
//        List<List<String>> result = new ArrayList<>();
//
//        for (int i = startIndex; i < s.length(); i++) {
//            if (isPalindrome(s, startIndex, i)) {
//                String sub = s.substring(startIndex, i + 1);
//                List<List<String>> dfsed = dfs(s, i + 1);
//                for (List<String> list : dfsed) {
//                    List<String> newList = new ArrayList<>();
//                    newList.add(sub);
//                    newList.addAll(list);
//                    result.add(newList);
//                }
//            }
//        }
//
//        cache.put(startIndex, result);
//        return result;
//    }
//
//    private static boolean isPalindrome(String s, int start, int end) {
//        while (start < end) {
//            if (s.charAt(start) != s.charAt(end)) {
//                return false;
//            }
//            start++;
//            end--;
//        }
//        return true;
//    }
}
