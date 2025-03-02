package com.bliznichenka.binarysearch.timebasedkeyvaluestore_981;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TimeMap {
    private final Map<String, List<Pair<Integer, String>>> map = new HashMap<>();

    public void set(String key, String value, int timestamp) {
        if (!map.containsKey(key)) {
            map.put(key, new ArrayList<>());
        }
        map.get(key).add(new Pair<>(timestamp, value));
    }

    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) {
            return "";
        }

        String result = "";
        List<Pair<Integer, String>> list = map.get(key);
        int l = 0;
        int r = list.size() - 1;

        while (l <= r) {
            int m = l + (r - l) / 2;

            Pair<Integer, String> val = list.get(m);
            if (val.getKey() > timestamp) {
                r = m - 1;
            } else {
                result = val.getValue();
                l = m + 1;
            }
        }

        return result;
    }
}
