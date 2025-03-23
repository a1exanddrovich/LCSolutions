package com.bliznichenka.backtracking.nqueensii_52;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int totalNQueens(int n) {
        return dfs(n, 0, new HashSet<>(), new HashSet<>(), new HashSet<>());
    }

    private static int dfs(
            int n,
            int curRow,
            Set<Integer> cols,
            Set<Integer> positiveDiags,
            Set<Integer> negativeDiags
    ) {
        if (curRow >= n) {
            return 1;
        }

        int count = 0;
        for (int col = 0; col < n; col++) {
            if (cols.contains(col)
                    || positiveDiags.contains(curRow + col)
                    || negativeDiags.contains(curRow - col)) {
                continue;
            }

            cols.add(col);
            positiveDiags.add(curRow + col);
            negativeDiags.add(curRow - col);
            count += dfs(n, curRow + 1, cols, positiveDiags, negativeDiags);
            cols.remove(col);
            positiveDiags.remove(curRow + col);
            negativeDiags.remove(curRow - col);
        }

        return count;
    }
}
