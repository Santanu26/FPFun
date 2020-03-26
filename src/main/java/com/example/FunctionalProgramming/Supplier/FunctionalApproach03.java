package com.example.FunctionalProgramming.Supplier;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

public class FunctionalApproach03 {

    public static void main(String[] args) {

        System.out.println(getUrl());
        System.out.println(getUrlBySupplier().get());
        System.out.println(getUrlBySuppliers().get());
    }

    static String getUrl() {
        return "localhost://4400";
    }

    static Supplier<String> getUrlBySupplier() {
        return () -> "localhost://4400/supplier";
    }

    static Supplier<List<String>> getUrlBySuppliers() {
        return () ->
                Arrays.asList(
                        "localhost://4400/supplier",
                        "localhost://4401/supplier",
                        "localhost://4402/supplier");
    }
}
