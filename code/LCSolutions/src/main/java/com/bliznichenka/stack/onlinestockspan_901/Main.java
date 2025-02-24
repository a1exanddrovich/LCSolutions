package com.bliznichenka.stack.onlinestockspan_901;

public class Main {
    public static void main(String[] args) {
        StockSpanner stockSpanner = new StockSpanner();

        stockSpanner.next(100); // return 1
        stockSpanner.next(80);  // return 1
        stockSpanner.next(60);  // return 1
        stockSpanner.next(70);  // return 2
        stockSpanner.next(60);  // return 1
        stockSpanner.next(75);  // return 4, because the last 4 prices (including today's price of 75) were less than or equal to today's price.
        stockSpanner.next(85);  // return 6
    }
}
