package com.bliznichenka.graphs.evaluatedivision_399;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Solution s = new Solution();

        List<List<String>> equations = List.of(
                List.of("a", "b"),
                List.of("b", "c"),
                List.of("bc", "cd")
        );
        double[] values = {1.5, 2.5, 5.0};
        List<List<String>> queries = List.of(
                List.of("a", "c"),
                List.of("c", "b"),
                List.of("bc", "cd"),
                List.of("cd", "bc")
        );
        System.out.println(Arrays.toString(s.calcEquation(equations, values, queries)));

    }

}
