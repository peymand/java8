package com.peyman.stream;

import java.time.Instant;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ArraysAndStream {
    public static void main(String[] args) {
        Integer[] values = {3, 10, 6, 1, 4, 8, 2, 5, 9, 7};

        //display original values
        System.out.printf("Original values: %s%n", Arrays.asList(values));

        //sort values in ascending
        List<Integer> collect = Arrays.stream(values).sorted().collect(Collectors.toList());

        //values greater than 4
        List<Integer> gt4 = Arrays.stream(values).filter(value -> value>4).collect(Collectors.toList());
        System.out.printf("values greater than 4 sorted %d","");
        gt4.stream().sorted().collect(Collectors.toList());
    }
}
