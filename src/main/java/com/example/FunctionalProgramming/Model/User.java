package com.example.FunctionalProgramming.Model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class User {

    private String name;

    private String email;

    private String phoneNumber;

    private LocalDate dob;
}
