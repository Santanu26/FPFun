package com.example.functionProgrammingPattern;

import java.util.ArrayList;
import java.util.List;

public class UserFacade {

    private UserRepo userRepo;

    public List<UserDto> getAllUsers() {
        List<User> users = userRepo.findAll();
        List<UserDto> userDtos = new ArrayList<>();

        for (User user : users) {
            UserDto userDto = new UserDto();
            userDto.setFullName(user.getFirstName() + " " + user.getLastName().toUpperCase());
            userDto.setUsername(user.getUsername());
            userDto.setActive(user.getDeactivationDate() == null);
            userDtos.add(userDto);
        }
        return userDtos;
    }
}
