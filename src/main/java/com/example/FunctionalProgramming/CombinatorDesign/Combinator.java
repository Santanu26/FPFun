package com.example.FunctionalProgramming.CombinatorDesign;

import com.example.FunctionalProgramming.Model.User;
import com.example.FunctionalProgramming.Service.UserService;

import java.time.LocalDate;

public class Combinator {
    public static void main(String[] args) {

        User user = new User("Alice",
                "alice@gmail.com",
                "+0888121212",
                LocalDate.of(20, 2, 20));

        System.out.println(new UserService().isValid(user));

        UserRegistrationValidator.ValidationResult result = UserRegistrationValidator.isValidEmail()
                .and(UserRegistrationValidator.isValidPhoneNumber())
                .and(UserRegistrationValidator.isValidDob())
                .apply(user);

        System.out.println(result);
        if(result!= UserRegistrationValidator.ValidationResult.SUCCESS) {
            throw new IllegalArgumentException(result.name());
        }

    }
}
