package com.bliznichenka.graphs.openthelock_752;

import java.util.*;

public class Solution {
    public int openLock(String[] deadends, String target) {
        Set<String> visited = new HashSet<>();
        Collections.addAll(visited, deadends);

        if (visited.contains("0000")) {
            return -1;
        }

        int moves = 0;
        Deque<String> deque = new ArrayDeque<>();
        deque.addFirst("0000");
        visited.add("0000");

        while (!deque.isEmpty()) {
            int len = deque.size();
            for (int k = 0; k < len; k++) {
                String curComb = deque.pollLast();
                if (curComb.equals(target)) {
                    return moves;
                }
                for (String nextComb : getCombinations(curComb)) {
                    if (!visited.contains(nextComb)) {
                        deque.addFirst(nextComb);
                        visited.add(nextComb);
                    }
                }
            }
            moves++;
        }

        return -1;
    }

    private static List<String> getCombinations(String comb) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            char[] nextComb = comb.toCharArray();
            int incremented = ((nextComb[i] - '0') + 1) % 10;
            nextComb[i] = (char) (incremented + '0');
            result.add(new String(nextComb));

            char[] prevComb = comb.toCharArray();
            int decremented = ((prevComb[i] - '0') - 1 + 10) % 10;
            prevComb[i] = (char) (decremented + '0');
            result.add(new String(prevComb));
        }
        return result;
    }
}
