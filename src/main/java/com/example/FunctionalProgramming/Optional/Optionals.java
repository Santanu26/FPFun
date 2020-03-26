package com.example.FunctionalProgramming.Optional;

import java.util.Optional;

public class Optionals {
    public static void main(String[] args) {

        Object value = Optional.ofNullable(null)
                .orElseGet(() -> "default value");
        System.out.println(value);


        Optional.ofNullable("testttttt")
                .ifPresent(System.out::println);

        Optional.ofNullable(null)
                .ifPresent(e -> System.out.println("nothing print"));

    }
}
