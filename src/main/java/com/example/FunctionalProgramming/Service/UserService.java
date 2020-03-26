package com.example.FunctionalProgramming.Service;

import com.example.FunctionalProgramming.Model.User;

import java.time.LocalDate;
import java.time.Period;

public class UserService {

    public boolean isValidPhoneNumber(String phoneNumber) {
        return phoneNumber.startsWith("+0");
    }

    public boolean isValidEmail(String email) {
        return email.contains("@");
    }

    public boolean isAdult(LocalDate dob) {
        return Period.between(dob, LocalDate.now()).getYears() > 16;
    }

    public boolean isValid(User user) {
        return isAdult(user.getDob()) && isValidEmail(user.getEmail()) && isValidPhoneNumber(user.getPhoneNumber());
    }


}
