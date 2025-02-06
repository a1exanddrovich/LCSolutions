package com.bliznichenka.arraysandhashing.encodeanddecodestrings_271;

import java.util.ArrayList;
import java.util.List;

public class Codec {
    private static final char DELIMITER = '#';

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();

        for (String str : strs) {
            sb.append(str.length());
            sb.append(DELIMITER);
            sb.append(str);
        }

        return sb.toString();
    }

    public List<String> decode(String s) {
        List<String> result = new ArrayList<>();

        int i = 0;
        while (i < s.length()) {
            StringBuilder count = new StringBuilder();

            while (s.charAt(i) != DELIMITER) {
                count.append(s.charAt(i));
                i++;
            }

            i++;
            int endIndex = i + Integer.parseInt(count.toString());
            StringBuilder part = new StringBuilder();
            while (i < endIndex) {
                part.append(s.charAt(i));
                i++;
            }
            result.add(part.toString());
        }

        return result;
    }
}
