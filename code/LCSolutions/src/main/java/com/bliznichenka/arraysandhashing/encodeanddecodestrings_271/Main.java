package com.bliznichenka.arraysandhashing.encodeanddecodestrings_271;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Codec codec = new Codec();

        System.out.println(codec.decode(codec.encode(List.of("Hello","World"))));
    }
}
