package com.bliznichenka.stack.simplifypath_71;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;

public class Solution {
    public String simplifyPath(String path) {
        String[] splitPath = path.split("/");

        Stack<String> stack = new Stack<>();

        for (String part : splitPath) {
            if (part.isEmpty()) {
                continue;
            }

            if (part.equals(".")) {
                continue;
            } else if (part.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(part);
            }
        }

        return "/" + String.join("/", stack);
    }
}
