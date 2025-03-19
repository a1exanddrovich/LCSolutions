package com.bliznichenka.tries.wordsearchii_212;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        char[][] board = {
                {'o', 'a', 'a', 'n'},
                {'e', 't', 'a', 'e'},
                {'i', 'h', 'k', 'r'},
                {'i', 'f', 'l', 'q'},
        };
        String[] words = {"oath","pea","eat","rain"};
        System.out.println(solution.findWords(board, words));
    }
}
