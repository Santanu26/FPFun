package com.example.FunctionalProgramming.Model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Customer {
    private final String customerName;
    private final String phoneNumber;
}