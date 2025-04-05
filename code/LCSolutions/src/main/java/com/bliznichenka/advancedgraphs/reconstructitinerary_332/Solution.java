package com.bliznichenka.advancedgraphs.reconstructitinerary_332;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, Queue<String>> adjacencyList = new HashMap<>();

        for (List<String> ticket : tickets) {
            if (!adjacencyList.containsKey(ticket.get(0))) {
                adjacencyList.put(ticket.get(0), new PriorityQueue<>());
            }
            adjacencyList.get(ticket.get(0)).add(ticket.get(1));
        }

        List<String> res = new ArrayList<>();

        res.add("JFK");
        dfs(adjacencyList, "JFK", res, tickets.size());

        return res;
    }

    private static boolean dfs(Map<String, Queue<String>> adjacencyList,
                               String src,
                               List<String> res,
                               int ticketsSize) {
        if (res.size() == ticketsSize + 1) {
            return true;
        }

        if (!adjacencyList.containsKey(src)) {
            return false;
        }

        Queue<String> tempDests = new PriorityQueue<>(adjacencyList.get(src));
        while (!tempDests.isEmpty()) {
            String dest = tempDests.poll();
            adjacencyList.get(src).remove(dest);
            res.add(dest);

            if (dfs(adjacencyList, dest, res, ticketsSize)) {
                return true;
            }

            adjacencyList.get(src).add(dest);
            res.remove(res.size() - 1);
        }

        return false;
    }
}
