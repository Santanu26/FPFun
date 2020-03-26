package com.example.functionProgrammingPattern.exampleForAssignValueIntoDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    @Autowired
     private OtherClass otherClass;

    public UserDto toDto(User user) {
        UserDto userDto = new UserDto();
        userDto.setFullName(user.getFirstName() + " " + user.getLastName().toUpperCase());
        userDto.setUsername(user.getUsername());
        userDto.setActive(user.getDeactivationDate() == null);

        // set other class

        return userDto;
    }
}
