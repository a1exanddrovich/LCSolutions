package com.bliznichenka.graphs.openthelock_752;

public class Main {

    public static void main(String[] args) {
        Solution s = new Solution();

        String[] deadends = {"0201","0101","0102","1212","2002"};
        String target = "0202";
        System.out.println(s.openLock(deadends, target));
    }

}
