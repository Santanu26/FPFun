package com.example.functionProgrammingPattern;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class UserFacade {

    private UserRepo userRepo;

    public List<UserDto> getAllUsers() {
        return userRepo.findAll().stream().map(this::toDto).collect(toList());
    }

    private UserDto toDto(User user) {
        UserDto userDto = new UserDto();
        userDto.setFullName(user.getFirstName() + " " + user.getLastName().toUpperCase());
        userDto.setUsername(user.getUsername());
        userDto.setActive(user.getDeactivationDate() == null);
        return userDto;
    }
}
