package com.example.FunctionalProgramming.BiFunction;

import java.util.function.BiFunction;
import java.util.function.Function;

public class FunctionalApproach01 {
    public static void main(String[] args) {
        Function<Integer, Integer> incrementByOne = number -> number + 1;
        Function<Integer, Integer> multiplyBy10 = number -> number * 10;

        System.out.println(incrementByOne.andThen(multiplyBy10).apply(20));

        BiFunction<Integer, Integer, Integer> increAndMultiply = (inc, mul) -> (inc + 1) * mul;

        System.out.println(increAndMultiply.apply(1, 100));

    }

}
