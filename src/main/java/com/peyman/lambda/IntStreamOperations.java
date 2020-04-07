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

        System.out.printf("%nCount: %d%n", IntStream.of(values).count());
        System.out.printf("Min: %d%n",IntStream.of(values).min().getAsInt());
        System.out.printf("Max: %d%n",IntStream.of(values).max().getAsInt());
        System.out.printf("Sum: %d%n",IntStream.of(values).sum());
        System.out.printf("Average: %.2f%n",IntStream.of(values).average().getAsDouble());
    }
}
