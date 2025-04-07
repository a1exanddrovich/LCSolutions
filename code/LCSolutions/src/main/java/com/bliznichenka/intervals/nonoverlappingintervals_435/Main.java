package com.bliznichenka.intervals.nonoverlappingintervals_435;

/*


 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[][] intervals = {{1, 2}, {2, 3}, {3, 4}, {1, 3}};
        System.out.println(solution.eraseOverlapIntervals(intervals));
    }
}
