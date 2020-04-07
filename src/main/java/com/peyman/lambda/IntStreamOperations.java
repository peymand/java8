package com.peyman.lambda;

import java.util.stream.IntStream;

public class IntStreamOperations {

    public static void main(String[] args) {
        int[] values = {3, 10, 6, 1, 4, 8, 2, 5, 9, 7};
        System.out.println("Original values: ");

        //stream pipeline
        IntStream.of(values)
                .forEach(value -> System.out.printf("%d ",value));
        System.out.println();

        //count, min, max, sum and avg of the values

    }
}
