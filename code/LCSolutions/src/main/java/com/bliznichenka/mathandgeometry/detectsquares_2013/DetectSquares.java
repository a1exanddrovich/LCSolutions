package com.bliznichenka.mathandgeometry.detectsquares_2013;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DetectSquares {
    private final Map<List<Integer>, Integer> map = new HashMap<>();

    public void add(int[] point) {
        List<Integer> list = List.of(point[0], point[1]);
        map.put(list, map.getOrDefault(list, 0) + 1);
    }

    public int count(int[] point) {
        int res = 0;

        for (List<Integer> secondPoint : map.keySet()) {
            // we can at least form a square diagonal with another point
            // if the x and y distance is the same and the points are different
            // and this is important because if the points are the same then the condition will
            // not fail, and it may increase the result by basically creating a square with
            // side len of 0 which is not accepted in the task.
            if ((point[0] != secondPoint.get(0))
                    && (point[1] != secondPoint.get(1))
                    && Math.abs(point[0] - secondPoint.get(0)) == Math.abs(point[1] - secondPoint.get(1))) {
                List<Integer> thirdPoint = List.of(point[0], secondPoint.get(1));
                List<Integer> forthPoint = List.of(secondPoint.get(0), point[1]);

                if (map.containsKey(thirdPoint) && map.containsKey(forthPoint)) {
                    res += (map.get(secondPoint) * map.get(thirdPoint) * map.get(forthPoint));
                }
            }
        }

        return res;
    }
}
