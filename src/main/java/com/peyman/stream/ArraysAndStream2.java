package com.peyman.stream;

import java.util.Arrays;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class ArraysAndStream2 {
    public static void main(String[] args) {
        String[] strings = {"Red", "orange", "yellow", "green", "blue", "indigo", "Violet"};

        System.out.printf("Original strings: %s%n", Arrays.asList(strings));

        System.out.printf("strings in uppercase: %s%n", Arrays.stream(strings).map(String::toUpperCase)
                .collect(Collectors.toList()));
        //strings greater than 'm' sorted ascending
        Arrays.stream(strings).filter(s->s.compareToIgnoreCase("m")>0)
                .sorted(String.CASE_INSENSITIVE_ORDER)
                .collect(Collectors.toList());
        //strings greater than 'm' sorted de1scending
        Arrays.stream(strings).filter(s->s.compareToIgnoreCase("m")>0)
                .sorted(String.CASE_INSENSITIVE_ORDER.reversed())
                .collect(Collectors.toList());
    }
}
