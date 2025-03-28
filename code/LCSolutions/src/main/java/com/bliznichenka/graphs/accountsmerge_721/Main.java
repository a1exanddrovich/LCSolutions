package com.bliznichenka.graphs.accountsmerge_721;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        Solution s = new Solution();

        List<List<String>> accounts = List.of(
                List.of("John","johnsmith@mail.com","john_newyork@mail.com"),
                List.of("John","johnsmith@mail.com","john00@mail.com"),
                List.of("Mary","mary@mail.com"),
                List.of("John","johnnybravo@mail.com")
        );
        System.out.println(s.accountsMerge(accounts));
    }

}
