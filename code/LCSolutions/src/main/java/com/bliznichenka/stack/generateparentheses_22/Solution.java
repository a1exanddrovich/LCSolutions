package com.bliznichenka.stack.generateparentheses_22;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        dfs(result, new StringBuilder(), n, 0, 0);
        return result;
    }

    private static void dfs(
            List<String> result,
            StringBuilder currentComb,
            int n,
            int open,
            int closed
    ) {
        if (open == n && closed == n) {
            result.add(currentComb.toString());
            return;
        }

        if (open < n) {
            currentComb.append("(");
            dfs(result, currentComb, n, open + 1, closed);
            currentComb.deleteCharAt(currentComb.length() - 1);
        }
        if (closed < open) {
            currentComb.append(")");
            dfs(result, currentComb, n, open, closed + 1);
            currentComb.deleteCharAt(currentComb.length() - 1);
        }
    }
}
