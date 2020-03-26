package com.example.functionProgrammingPattern.exampleForAssignValueIntoDto;

import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    //@Autowired
    // private OtherDep dep;
    public UserDto toDto(User user) {
        UserDto userDto = new UserDto();
        userDto.setFullName(user.getFirstName() + " " + user.getLastName().toUpperCase());
        userDto.setUsername(user.getUsername());
        userDto.setActive(user.getDeactivationDate() == null);
        return userDto;
    }
}
