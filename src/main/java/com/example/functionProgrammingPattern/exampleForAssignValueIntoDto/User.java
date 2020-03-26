package com.example.functionProgrammingPattern.exampleForAssignValueIntoDto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class User {
    private String username;
    private String firstName;
    private String lastName;
    private LocalDate deactivationDate;
}
