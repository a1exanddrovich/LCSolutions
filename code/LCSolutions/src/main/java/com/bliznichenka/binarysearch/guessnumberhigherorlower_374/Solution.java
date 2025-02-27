package com.bliznichenka.binarysearch.guessnumberhigherorlower_374;

public class Solution {
    public int guessNumber(int n) {
        int l = 1;
        int r = n;

        while (l <= r) {
            int m = l + (r - l) / 2;
            int tryGuess = guess(m);

            if (tryGuess == 0) {
                return m;
            } else if (tryGuess == 1) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }

        return -1;
    }

    //This is the third-party API that we may call to check our guesses
    /**
     * Forward declaration of guess API.
     *
     * @param num your guess
     * @return -1 if num is higher than the picked number
     * 1 if num is lower than the picked number
     * otherwise return 0
     * int guess(int num);
     */
    private int guess(int num) {
        int n = 7;

        if (num > n) {
            return -1;
        }

        if (num < n) {
            return 1;
        }

        return 0;
    }
}


