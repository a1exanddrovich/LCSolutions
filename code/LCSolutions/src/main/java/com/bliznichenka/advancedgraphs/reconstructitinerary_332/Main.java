package com.bliznichenka.advancedgraphs.reconstructitinerary_332;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();

        // new ArrayList constructor to let the list be sorted in
        // the solution method :)
        List<List<String>> tickets = new ArrayList<>(List.of(
                List.of("JFK", "KUL"),
                List.of("JFK", "NRT"),
                List.of("NRT", "JFK")
        ));
        System.out.println(s.findItinerary(tickets));
    }
}