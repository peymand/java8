package com.peyman.lambda;

import java.util.stream.IntStream;

public class IntStreamOperations {

    public static void main(String[] args) {
        int[] values = {3, 10, 6, 1, 4, 8, 2, 5, 9, 7};
        System.out.println("Original values: ");

        //stream pipeline
        IntStream.of(values)
                .forEach(value -> System.out.printf("%d ", value));
        System.out.println();

        //count, min, max, sum and avg of the values

        System.out.printf("%nCount: %d%n", IntStream.of(values).count());
        System.out.printf("Min: %d%n", IntStream.of(values).min().getAsInt());
        System.out.printf("Max: %d%n", IntStream.of(values).max().getAsInt());
        System.out.printf("Sum: %d%n", IntStream.of(values).sum());
        System.out.printf("Average: %.2f%n", IntStream.of(values).average().getAsDouble());
        //sum of values with reduce method
        System.out.printf("%nSum via reduce method: %d%n", IntStream.of(values)
                .reduce(0, (x, y) -> {
                    System.out.printf("x=%d , y=%d", x, y);
                    return x + y;
                })); //Integer::sum
        //sum of squares of values with reduce method
        System.out.printf("Sum of squares via reduce method: %d%n",
                IntStream.of(values)
                        .reduce(0, (x, y) -> x + (x + y)));
        //even values displayed in sorted order
        IntStream.of(values).filter(value -> value%2==0)
                .sorted().forEach(value -> System.out.printf("%d ",value));
        System.out.println();

        //odd values multiplied by 10 and displayed in sorted order
        IntStream.of(values).filter(value -> value%2!=0)
                .map(value -> value*10).sorted()
                .forEach(value -> System.out.printf("%d ",value));
        //sum range of integers from 1 to 10, exclusive
        System.out.println(IntStream.range(1, 10).sum());
        System.out.println(IntStream.rangeClosed(1, 10).sum());
    }
}
