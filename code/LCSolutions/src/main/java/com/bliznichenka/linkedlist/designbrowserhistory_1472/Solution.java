package com.bliznichenka.linkedlist.designbrowserhistory_1472;

public class Solution {

    public static void main(String[] args) {
        BrowserHistory browserHistory = new BrowserHistory("leetcode.com");

        // You are in "leetcode.com". Visit "google.com"
        browserHistory.visit("google.com");

        // You are in "google.com". Visit "facebook.com"
        browserHistory.visit("facebook.com");

        // You are in "facebook.com". Visit "youtube.com"
        browserHistory.visit("youtube.com");

        // You are in "youtube.com", move back to "facebook.com" return "facebook.com"
        System.out.println(browserHistory.back(1));

        // You are in "facebook.com", move back to "google.com" return "google.com"
        System.out.println(browserHistory.back(1));

        // You are in "google.com", move forward to "facebook.com" return "facebook.com"
        System.out.println(browserHistory.forward(1));

        // You are in "facebook.com". Visit "linkedin.com"
        browserHistory.visit("linkedin.com");

        // You are in "linkedin.com", you cannot move forward any steps.
        System.out.println(browserHistory.forward(2));

        // You are in "linkedin.com", move back two steps to "facebook.com"
        // then to "google.com". return "google.com"
        System.out.println(browserHistory.back(2));

        // You are in "google.com", you can move back only one step to "leetcode.com".
        // return "leetcode.com"
        System.out.println(browserHistory.back(7));
    }

}
