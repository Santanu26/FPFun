package com.example.FunctionalProgramming.CombinatorDesign;

import com.example.FunctionalProgramming.Model.User;

import java.time.LocalDate;
import java.time.Period;
import java.util.function.Function;

import static com.example.FunctionalProgramming.CombinatorDesign.UserRegistrationValidator.ValidationResult;
import static com.example.FunctionalProgramming.CombinatorDesign.UserRegistrationValidator.ValidationResult.IS_NOT_VALID;
import static com.example.FunctionalProgramming.CombinatorDesign.UserRegistrationValidator.ValidationResult.SUCCESS;

public interface UserRegistrationValidator extends Function<User, ValidationResult> {

    static UserRegistrationValidator isValidEmail() {
        return user -> user.getEmail().contains("@") ? SUCCESS : IS_NOT_VALID;
    }

    static UserRegistrationValidator isValidPhoneNumber() {
        return user -> user.getPhoneNumber().startsWith("+0") ? SUCCESS : IS_NOT_VALID;
    }

    static UserRegistrationValidator isValidDob() {
        return user -> Period.between(user.getDob(), LocalDate.now()).getYears() > 16 ? SUCCESS : IS_NOT_VALID;
    }

    default UserRegistrationValidator and(UserRegistrationValidator other) {
        return user -> {
            ValidationResult result = this.apply(user);
            return result.equals(SUCCESS) ? this.apply(user) : result;
        };
    }

    enum ValidationResult {
        SUCCESS,
        IS_NOT_VALID
    }
}
