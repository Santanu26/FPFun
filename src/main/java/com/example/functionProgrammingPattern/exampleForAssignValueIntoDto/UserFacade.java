package com.example.functionProgrammingPattern.exampleForAssignValueIntoDto;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class UserFacade {

    private UserRepo userRepo;

    @Autowired
    private UserMapper mapper;

    public List<UserDto> getAllUsers() {
        return userRepo.findAll().stream().map(mapper::toDto).collect(toList());
    }
}
